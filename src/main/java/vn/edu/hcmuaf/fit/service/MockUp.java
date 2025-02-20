package vn.edu.hcmuaf.fit.service;

import vn.edu.hcmuaf.fit.model.Order;

import java.util.ArrayList;
import java.util.List;

public class MockUp {

    public static List<Order> orderList() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Iphone 14", "Mobile", "Apple", 3, 580.25));
        orders.add(new Order(2, "Iphone 14 Pro", "Mobile", "Apple", 5, 790.25));
        orders.add(new Order(3, "Samsung Galaxy", "Mobile", "Samsung", 7, 800.5));
        orders.add(new Order(4, "Samsung Watch 5", "Watch", "Samsung", 2, 400.35));
        orders.add(new Order(5, "MackBook Pro", "Laptop", "Apple", 4, 920.75));
        orders.add(new Order(6, "Nokia 2630", "Mobile", "Nokia", 2, 760.55));

        return orders;
    }
}
