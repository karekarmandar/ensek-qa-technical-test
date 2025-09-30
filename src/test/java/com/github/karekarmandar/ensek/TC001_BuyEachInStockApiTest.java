package com.github.karekarmandar.ensek;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TC001_BuyEachInStockApiTest extends BaseApiTest {

    @Test
    @Order(1)
    void discoverStock_and_buySmallQuantityEach() {
        // Fetch all fuels
        List<Map<String, Object>> fuels = getFuels();

        // show what we actually received Print
        System.out.println("\n=== DEBUG TC001: /energy payload (parsed) ===");
        System.out.println("total fuels returned: " + (fuels == null ? "null" : fuels.size()));
        if (fuels != null) {
            for (Map<String, Object> f : fuels) {
                System.out.println(" - " + f);
            }
        }
        System.out.println("=============================================\n");

        // Filter to in-stock fuels
        List<Map<String, Object>> available = inStock(fuels);

        // More context if nothing is in stock
        if (available == null || available.isEmpty()) {
            System.out.println("No in-stock items found. Quantities by returned items:");
            if (fuels != null) {
                for (Map<String, Object> f : fuels) {
                    Object id = f.get("id");
                    Object type = f.get("type");
                    Object qty = f.get("quantity");
                    System.out.println("   id=" + id + ", type=" + type + ", quantity=" + qty);
                }
            }
        }

        // at least one fuel should be in stock
        assertThat("At least one fuel should be in stock", available.size(), greaterThan(0));

        // buy a small quantity of each in-stock fuel
        for (Map<String, Object> f : available) {
            int id = Integer.parseInt(f.get("id").toString());
            int qtyToBuy = 1; 

            String type = String.valueOf(f.get("type")).toLowerCase(Locale.ROOT);
            int stock = Integer.parseInt(f.get("quantity").toString());
            if (type.contains("gas"))      qtyToBuy = Math.min(15, stock);
            if (type.contains("electric")) qtyToBuy = Math.min(2,  stock);
            if (type.contains("oil"))      qtyToBuy = Math.min(1,  stock);

            var result = buyFuel(id, qtyToBuy);
            assertThat("server returned a message", result.get("rawMessage"), notNullValue());
            createdOrders.add(result);
        }

        // verify stock decremented
        var after = getFuels();
        for (Map<String, Object> purchase : createdOrders) {
            int id  = Integer.parseInt(purchase.get("energy_id").toString());
            int qty = Integer.parseInt(purchase.get("quantity").toString());

            int beforeQty = Integer.parseInt(findById(fuels, id).get("quantity").toString());
            int afterQty  = Integer.parseInt(findById(after, id).get("quantity").toString());

            assertThat("quantity decreased by purchase amount", beforeQty - afterQty, equalTo(qty));
        }
    }

    private Map<String, Object> findById(List<Map<String, Object>> list, int id) {
        return list.stream()
                .filter(m -> Integer.parseInt(m.get("id").toString()) == id)
                .findFirst()
                .orElseThrow();
    }
}
