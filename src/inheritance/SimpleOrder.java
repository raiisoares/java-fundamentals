package inheritance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class SimpleOrder implements Order {
    private final UUID orderId;
    private final Customer customer;
    private final LocalDateTime orderDate;
    private final List<OrderItem> items;

    public SimpleOrder(Customer customer, List<OrderItem> items) {
        this.orderId = UUID.randomUUID();
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
        this.items = items;
    }

    @Override
    public UUID getId() {
        return this.orderId;
    }

    @Override
    public Customer getClient() {
        return this.customer;
    }

    @Override
    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    @Override
    public List<OrderItem> getItems() {
        return this.items;
    }

    @Override
    public double getTotalValue() {
        double total = 0;

        for (OrderItem item : this.items) {
            total += item.getPrice() * item.getQuantity();
        }

        double shippingCost = 15.99;
        return total + shippingCost;
    }

    @Override
    public double getTotalValue(double discount) {
        return getTotalValue() - applyDiscount(discount);
    }

    @Override
    public double applyDiscount(double discount) {
        return (getTotalValue() * discount);
    }
}
