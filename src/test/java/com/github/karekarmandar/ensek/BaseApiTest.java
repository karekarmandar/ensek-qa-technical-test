package com.github.karekarmandar.ensek;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseApiTest {

    protected static final String BASE_URI = "https://qacandidatetest.ensek.io";
    protected static final List<Map<String, Object>> createdOrders = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = "/ENSEK";
    }

    /** Fetch fuels;  */
    protected List<Map<String, Object>> getFuels() {
        String body =
            given()
                .when().get("/energy")
                .then().statusCode(200)
                .extract().asString();

        JsonPath jp = JsonPath.from(body);

        // Operator 
        List<Map<String, Object>> fuels = tryGetList(jp, "$");

        // wrapper keys
        if (fuels == null) fuels = tryGetList(jp, "items");
        if (fuels == null) fuels = tryGetList(jp, "data");
        if (fuels == null) fuels = tryGetList(jp, "fuels");
        if (fuels == null) fuels = tryGetList(jp, "energy");

        //  find the first list nested under the root object
        if (fuels == null) {
            Map<String, Object> root = jp.getMap("$");
            if (root != null) {
                for (Object v : root.values()) {
                    if (v instanceof List) {
                        // noinspection unchecked
                        fuels = (List<Map<String, Object>>) v;
                        break;
                    }
                }
            }
        }

        // Final assertions to ensure we got something sensible
        assertThat("fuels list present", fuels, is(notNullValue()));
        assertThat("fuels have expected keys",
                fuels.get(0).keySet(), hasItems("id", "type", "price", "quantity", "unit"));

        return fuels;
    }

    /**  try to read a list of maps from JsonPath; return null if not a list. */
    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> tryGetList(JsonPath jp, String path) {
        try {
            Object val = jp.get(path);
            if (val instanceof List) return (List<Map<String, Object>>) val;
            return null;
        } catch (ClassCastException ignored) {
            return null;
        } catch (Exception ignored) {
            return null;
        }
    }

    protected Map<String, Object> buyFuel(int id, int qty) {
        String resp =
            given()
                .when().put("/buy/{id}/{qty}", id, qty)
                .then().statusCode(200)
                .extract().asString();

        Map<String, Object> result = new HashMap<>();
        result.put("energy_id", id);
        result.put("quantity", qty);
        result.put("rawMessage", resp);

        String uuid = extractUuid(resp);
        if (uuid != null) result.put("orderId", uuid);

        result.put("createdAtStart", Instant.now().minusSeconds(5).toString());
        result.put("createdAtEnd", Instant.now().plusSeconds(5).toString());
        return result;
    }

    protected List<Map<String, Object>> getOrders() {
        String body =
            given()
                .when().get("/orders")
                .then().statusCode(200)
                .extract().asString();
        return JsonPath.from(body).getList("$");
    }

    protected long countOrdersBeforeTodayUtc(List<Map<String, Object>> orders) {
        Instant cutoff = LocalDate.now(ZoneOffset.UTC).atStartOfDay().toInstant(ZoneOffset.UTC);
        return orders.stream()
                .filter(o -> o != null && o.get("time") != null)
                .filter(o -> {
                    try { return Instant.parse(o.get("time").toString()).isBefore(cutoff); }
                    catch (Exception e) { return false; }
                })
                .count();
    }

    protected static List<Map<String, Object>> inStock(List<Map<String, Object>> fuels) {
        return fuels.stream()
                .filter(f -> {
                    Object q = f.get("quantity");
                    if (q == null) return false;
                    try { return Integer.parseInt(q.toString()) > 0; }
                    catch (NumberFormatException e) { return false; }
                })
                .collect(Collectors.toList());
    }

    private String extractUuid(String s) {
        if (s == null) return null;
        return Arrays.stream(s.split("[\\s\\.,]"))
                .filter(tok -> tok.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"))
                .findFirst().orElse(null);
    }
}
