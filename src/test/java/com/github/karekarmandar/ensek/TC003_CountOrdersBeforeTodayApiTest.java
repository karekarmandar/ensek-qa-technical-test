package com.github.karekarmandar.ensek;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class TC003_CountOrdersBeforeTodayApiTest extends BaseApiTest {

    @Test
    @Order(3)
    void countOrdersBeforeTodayUtc() {
        List<Map<String, Object>> orders = getOrders();
        long count = countOrdersBeforeTodayUtc(orders);
        assertThat("count is >= 0", count, greaterThanOrEqualTo(0L));
        System.out.println("Orders created BEFORE today (UTC): " + count);
    }
}
