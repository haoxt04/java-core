package vn.edu.hcmuaf.fit;

import vn.edu.hcmuaf.fit.model.Order;
import vn.edu.hcmuaf.fit.service.MockUp;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        // allMatch();
        // anyMatch();
        // noneMatch();
        // streamBuilder();
        // collect();
        // streamConcat();
        // distinct();
        // findAny();
        // findFirst();
        // flatMap();
        // generate();
        // common();
        // sort();
        // skip();
        // peek();
        List<Order> orders = MockUp.orderList();
//        System.out.println(getOrderByType());
//        System.out.println(sumOfOrderQuantity(orders));
//        System.out.println(orderOfHighestPrice(orders));
//        System.out.println(sumOfOrderPrice(orders));
//        System.out.println(list700Orders(orders));
//        System.out.println(getOderPriceLess500(orders));
//        System.out.println(checkOrderOfApple(orders));
        System.out.println(checkOrderPrice1000(orders));
    }
    // 1. Lọc danh sách đơn hàng theo loại sản phẩm
    public static List<Order> getOrderByType() {
        return MockUp.orderList().stream().filter(order -> order.getProductType().equals("Mobile")).toList();
    }


    // 2. Tính tồng số lượng sản phẩm của tất cả đơn hàng
    public static int sumOfOrderQuantity(List<Order> orders) {
        return orders.stream().mapToInt(Order::getQuantity).sum();
    }

    // 3. Tìm đơn hàng có giá cao nhất
    public static Optional<Order> orderOfHighestPrice(List<Order> orders) {
        return orders.stream().max(Comparator.comparingDouble(Order::getPrice));
    }

    // 4. Tính tổng giá các sản phẩm có trong đơn hàng
    public static double sumOfOrderPrice(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getPrice).sum();
    }

    // 5. Sử dụng findAny để tìm đơn hàng có giá dưới 500
    public static Optional<Order> getOderPriceLess500(List<Order> orders) {
        return orders.stream().filter(order -> order.getPrice() < 500).findAny();
    }

    // 6. Lấy ra danh sách đơn hàng có giá trên 700
    public static List<Order> list700Orders(List<Order> orders) {
        return orders.stream().filter(order -> order.getPrice() > 700).collect(Collectors.toList());
    }

    // 7. Kiểm tra xem tất cả đơn hàng có phải là sản phẩm của Apple không
    public static boolean checkOrderOfApple(List<Order> orders) {
        return orders.stream().allMatch(order -> order.getVendor().equals("Apple"));
    }

    // 8. Lọc các đơn hàng của Apple và sắp xếp theo giá
    public static void sortAppleOrder(List<Order> orders) {
        orders.stream().filter(order -> order.getVendor().equals("Apple")).sorted(Comparator.comparingDouble(Order::getPrice));
    }

    // 9. Kiểm tra xem có ít nhất một đơn hàng là của Samsung không
    public static boolean checkOrderOfSamsung(List<Order> orders) {
        return orders.stream().anyMatch(order -> order.getVendor().equals("Samsung"));
    }

    // 10. Kiểm tra xem không có đơn hàng nào có giá trên 1000 không (noneMatch)
    public static boolean checkOrderPrice1000(List<Order> orders) {
        return orders.stream().noneMatch(order -> order.getPrice() > 1000);
    }

    // 11. Sử dụng distinct() để lấy ra danh sách các nhà cung cấp (vendor) duy nhất
    public static List<String> getDistinctVendor(List<Order> orders) {
        return orders.stream().map(Order::getVendor).distinct().collect(Collectors.toList());
    }

    // 12. Sắp xếp các đơn hàng theo giá từ thấp đến cao
    public static List<Order> sortFromCheaptoHighPrice(List<Order> orders) {
        return orders.stream().sorted(Comparator.comparingDouble(Order::getPrice)).collect(Collectors.toList());
    }

    // 13. Sử dụng skip() để bỏ qua n phần tử đầu tiên và in ra phần tử còn lại.
    public static List<Order> printAllExceptTheFirst(List<Order> orders, int n) {
        return orders.stream().skip(n).collect(Collectors.toList());
    }

    // 14. Sử dụng peek() để kiểm tra giá trị của các phần tử trong Stream mà không thay đổi Stream.
    public static void peekOrder(List<Order> orders) {
        orders.stream().peek(order -> System.out.println(order.getProductName())).toList();
    }

    // 15. Tính giá trị trung bình của tất cả các đơn hàng
    public static OptionalDouble avaragePriceOfOrders(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getPrice).average();
    }

    // 16. Sử dụng findFirst() để lấy đơn hàng có số lượng nhiều nhất
    public static Optional<Order> findFirstOfOrders(List<Order> orders) {
        return orders.stream().max(Comparator.comparingInt(Order::getQuantity));
    }

}