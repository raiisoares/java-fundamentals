package inheritance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ExpressOrder implements Order {
    private final UUID orderId;
    private final Client client;
    private final LocalDateTime orderDate;
    private final List<OrderItem> items;
    private final double expressShippingCost;

    public ExpressOrder(Client client, List<OrderItem> items, double expressShippingCost) {
        this.orderId = UUID.randomUUID();
        this.client = client;
        this.orderDate = LocalDateTime.now();
        this.items = items;
        this.expressShippingCost = expressShippingCost;
    }

    @Override
    public UUID getId() {
        return this.orderId;
    }

    @Override
    public Client getClient() {
        return this.client;
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

        return total + expressShippingCost;
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
