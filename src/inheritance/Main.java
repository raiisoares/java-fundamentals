package inheritance;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        seed(store);

        System.out.println(store.getOrders());

        System.out.println(store.findOrderById(UUID.fromString("08885f0c-f950-449e-9f02-7fb58ae4162c")));

        System.out.printf("Total revenue: R$%.2f %n", store.getRevenue());
    }

    private static void seed(Store store) {
        Client client01 = new Client("Cliente 01", "client 01 Address");
        Client client02 = new Client("Cliente 02", "client 02 Address");
        Client client03 = new Client("Cliente 03", "client 03 Address");
        Client client04 = new Client("Cliente 04", "client 04 Address");
        Product product01 = new Product("Product 01", "Product 01 description", 100d);
        Product product02 = new Product("Product 02", "Product 02 description", 19.99);
        Product product03 = new Product("Product 03", "Product 03 description", 59.90);
        Product product04 = new Product("Product 04", "Product 04 description", 99.99);
        OrderItem orderItem01 = new OrderItem(product01, 10, product01.getUnitPrice());
        OrderItem orderItem02 = new OrderItem(product02, 5, product02.getUnitPrice());
        OrderItem orderItem03 = new OrderItem(product03, 3, product03.getUnitPrice());
        OrderItem orderItem04 = new OrderItem(product03, 4, product03.getUnitPrice());
        OrderItem orderItem05 = new OrderItem(product02, 7, product02.getUnitPrice());

        store.addProduct(product01);
        store.addProduct(product02);
        store.addProduct(product03);
        store.removeProduct(product04);

        store.createSimpleOrder(client01, List.of(orderItem01, orderItem02));
        store.createSimpleOrder(client02, List.of(orderItem01, orderItem02, orderItem04));
        store.createSimpleOrder(client03, List.of(orderItem03));
        store.createSimpleOrder(client04, List.of(orderItem05, orderItem02, orderItem01, orderItem04));

        store.createExpressOrder(client01, List.of(orderItem01, orderItem02, orderItem05), 29.90);
        store.createExpressOrder(client02, List.of(orderItem01, orderItem02, orderItem03), 35d);
        store.createExpressOrder(client03, List.of(orderItem02, orderItem03), 52.41);
        store.createExpressOrder(client04, List.of(orderItem05, orderItem04), 74d);
    }
}
