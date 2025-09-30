package com.github.karekarmandar.ensek;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TC002_OrdersContainPurchasesApiTest extends BaseApiTest {

    @Test
    @Order(2)
    void ordersIncludeAllPurchases_withExpectedFields() {
        List<Map<String, Object>> orders = getOrders();
        assertThat(orders, is(not(empty())));

        for (Map<String, Object> created : createdOrders) {
            String maybeId = (String) created.get("orderId");
            Integer energyId = Integer.parseInt(created.get("energy_id").toString());
            Integer qty = Integer.parseInt(created.get("quantity").toString());

            Map<String, Object> match = orders.stream().filter(o -> {
                if (maybeId != null && maybeId.equals(o.get("id"))) return true;
                try {
                    return energyId.equals(Integer.parseInt(String.valueOf(o.get("energy")))) &&
                           qty.equals(Integer.parseInt(String.valueOf(o.get("quantity"))));
                } catch (Exception e) { return false; }
            }).findFirst().orElse(null);

            assertThat("order present for purchase " + created, match, notNullValue());
            assertThat(match, hasKey("id"));
            assertThat(match, hasKey("energy"));
            assertThat(match, hasKey("quantity"));
            assertThat(match, hasKey("time"));

            assertThat(Integer.parseInt(String.valueOf(match.get("energy"))), equalTo(energyId));
            assertThat(Integer.parseInt(String.valueOf(match.get("quantity"))), equalTo(qty));
        }
    }
}
