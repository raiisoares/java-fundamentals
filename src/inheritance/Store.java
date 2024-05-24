package inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Store {
    private List<Product> products;
    private List<SimpleOrder> simpleOrders;
    private List<ExpressOrder> expressOrders;

    public Store() {
        this.products = new ArrayList<>();
        this.simpleOrders = new ArrayList<>();
        this.expressOrders = new ArrayList<>();
    }

    public String getProducts() {
        StringBuilder builder = new StringBuilder();
        for (Product product : products) {
            builder.append(product.toString()).append("\n");
        }

        return builder.toString();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void createSimpleOrder(Client client, List<OrderItem> orderItems) {
        simpleOrders.add(new SimpleOrder(client, orderItems));
    }

    public void createExpressOrder(Client client, List<OrderItem> orderItems, double shippingCost) {
        expressOrders.add(new ExpressOrder(client, orderItems, shippingCost));
    }

    public String getOrders() {
        StringBuilder builder = new StringBuilder();

        builder.append("************* Simple Orders *************\n");
        for (SimpleOrder order : simpleOrders) {
            builder.append("ID: ").append(order.getId()).append(" ")
                    .append("| Date: ").append(order.getOrderDate()).append(" ")
                    .append("| Value: R$").append(String.format("%.2f", order.getTotalValue())).append("\n");
        }

        builder.append("************* Express Orders *************\n");
        for (ExpressOrder order : expressOrders) {
            builder.append("ID: ").append(order.getId()).append(" ")
                    .append("| Date: ").append(order.getOrderDate()).append(" ")
                    .append("| Value: R$").append(String.format("%.2f", order.getTotalValue())).append("\n");
        }

        return builder.toString();
    }

    public String findOrderById(UUID id) {
        Optional<? extends Order> optionalOrder = findOrderByIdInLists(id, expressOrders, simpleOrders);

        if (optionalOrder.isEmpty()) {
            return "No order found!";
        }

        Order order = optionalOrder.get();

        return "ID: " + order.getId() + " " + "| Date: " + order.getOrderDate() + " " +
                "| Value: R$" + String.format("%.2f", order.getTotalValue()) + "\n";
    }

    @SafeVarargs
    private Optional<? extends Order> findOrderByIdInLists(UUID id, List<? extends Order>... orderLists) {
        for (List<? extends Order> orders : orderLists) {
            Optional<? extends Order> optionalOrder = orders.stream()
                    .filter(order -> order.getId().equals(id)).findFirst();

            if (optionalOrder.isPresent()) {
                return optionalOrder;
            }
        }

        return Optional.empty();
    }

    public double getRevenue() {
        double revenue = 0;

        for (SimpleOrder order : simpleOrders) {
            revenue += order.getTotalValue();
        }

        for (ExpressOrder order : expressOrders) {
            revenue += order.getTotalValue();
        }

        return revenue;
    }

}
