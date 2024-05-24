package inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Store {
    private List<Product> products;
    private List<Customer> customers;
    private List<SimpleOrder> simpleOrders;
    private List<ExpressOrder> expressOrders;

    public Store() {
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.simpleOrders = new ArrayList<>();
        this.expressOrders = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public SimpleOrder createSimpleOrder(Customer customer, List<OrderItem> orderItems) {
        SimpleOrder order = new SimpleOrder(customer, orderItems);
        simpleOrders.add(order);
        return order;
    }

    public ExpressOrder createExpressOrder(Customer customer, List<OrderItem> orderItems, double shippingCost) {
        ExpressOrder order = new ExpressOrder(customer, orderItems, shippingCost);
        expressOrders.add(order);
        return order;
    }

    public String getProducts() {
        StringBuilder builder = new StringBuilder();
        for (Product product : products) {
            builder.append("Nome: ").append(product.getProductName()).append(" ")
                    .append("| Descrição: ").append(product.getDescription()).append(" ")
                    .append("| Preço: R$").append(String.format("%.2f", product.getUnitPrice())).append("\n");
        }

        return builder.toString();
    }

    public Product getProductByName(String productName) {
        Optional<Product> product = products.stream().filter(p -> p.getProductName().equals(productName)).findFirst();
        return product.orElse(null);
    }

    public String getCustomers() {
        StringBuilder builder = new StringBuilder();
        for (Customer customer : customers) {
            builder.append("Nome: ").append(customer.getName()).append(" ")
                    .append("| Endereço: ").append(customer.getAddress()).append("\n");
        }
        return builder.toString();
    }

    public Customer findCustomerByName(String name) {
        Optional<Customer> customer = customers.stream().filter(c -> c.getName().equals(name)).findFirst();
        return customer.orElse(null);
    }

    public String getOrders() {
        StringBuilder builder = new StringBuilder();

        builder.append("************* Pedidos Padrão *************\n");
        for (SimpleOrder order : simpleOrders) {
            builder.append("ID: ").append(order.getId()).append(" ")
                    .append("| Date: ").append(order.getOrderDate()).append(" ")
                    .append("| Value: R$").append(String.format("%.2f", order.getTotalValue())).append("\n");
        }

        builder.append("************* Pedidos Express *************\n");
        for (ExpressOrder order : expressOrders) {
            builder.append("ID: ").append(order.getId()).append(" ")
                    .append("| Data: ").append(order.getOrderDate()).append(" ")
                    .append("| Valor: R$").append(String.format("%.2f", order.getTotalValue())).append("\n");
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
