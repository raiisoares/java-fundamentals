package inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        boolean loop = true;
        int op;
        seed(store);
        String menuView = """
                ************* Menu *************
                Escolha uma ação:
                1 - Listar clientes.
                2 - Listar produtos.
                3 - Listar pedidos.
                4 - Exibir detalhes de pedido.
                5 - Cadastrar cliente.
                6 - Cadastrar produto.
                7 - Cadastrar pedido.
                8 - Mostrar receita.
                0 - Sair.
                """;

        do {
            System.out.println(menuView);
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.println("************* Clientes *************\n" + store.getCustomers());
                    break;
                case 2:
                    System.out.println("************* Produtos ************* \n" + store.getProducts());
                    break;
                case 3:
                    System.out.println("************* Pedidos *************\n" + store.getOrders());
                    break;
                case 4:
                    System.out.println("Informe o ID do pedido.");
                    String id = scanner.nextLine().trim();
                    System.out.println("\n");

                    try {
                        UUID uuid = UUID.fromString(id);
                        System.out.println("************* Detalhes do Pedido *************\n");
                        System.out.println(store.findOrderById(uuid));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: UUID inválido. Certifique-se de que o ID está no formato correto.");
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome do cliente.");
                    String customerName = scanner.nextLine();
                    System.out.println("Informe o endereço do cliente.");
                    String customerAddress = scanner.nextLine();
                    try {
                        store.addCustomer(new Customer(customerName, customerAddress));
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar cliente;");
                    }
                    break;
                case 6:
                    System.out.println("Informe o nome do produto.");
                    String productName = scanner.nextLine();
                    System.out.println("Informe a descrição do produto.");
                    String productDescription = scanner.nextLine();
                    System.out.println("Informe a preço do produto. ** Utilize virgula ',' caso necessário. **");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        store.addProduct(new Product(productName, productDescription, productPrice));
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar Produto;");
                    }
                    break;
                case 7:
                    try {
                        Order order = createOrder(scanner, store);
                        System.out.println("************* Pedido criado *************\n");
                        System.out.println(store.findOrderById(order.getId()));
                    } catch (Exception e) {
                        System.out.println("Erro ao cadastrar pedido;");
                    }
                    break;
                case 8:
                    System.out.printf("************* Faturamento *************\n " +
                                      "Faturamento total: R$%.2f %n %n", store.getRevenue());
                    break;
                case 0:
                    loop = false;
                    scanner.close();
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (loop);

    }

    private static Order createOrder(Scanner scanner, Store store) {
        List<OrderItem> orderItems = createOrderItems(scanner, store);
        Customer customer = getCustomer(scanner, store);
        System.out.println("O pedido é Expresso? Digite 's' para sim ou 'n' para não.");
        String isExpress = scanner.next();

        if (isExpress.equals("s")) {
            System.out.println("Informe o valor do frete: ** Utilize virgula ',' caso necessário. **");
            double shippingCost = scanner.nextDouble();
            return store.createExpressOrder(customer, orderItems, shippingCost);
        }

        return store.createSimpleOrder(customer, orderItems);
    }

    private static Customer getCustomer(Scanner scanner, Store store) {
        System.out.println("** O cliente precisa estar cadastrado na loja **");
        System.out.println("Agora informe o nome do cliente: ");
        String customerName = scanner.nextLine();
        return store.findCustomerByName(customerName);
    }

    private static List<OrderItem> createOrderItems(Scanner scanner, Store store) {
        List<OrderItem> orderItems = new ArrayList<>();
        boolean loop = true;
        int op;
        String optionsView = """
                ************* Adicionar itens *************
                Escolha uma ação:
                1 - Adicionar um item.
                0 - Finalizar adição de items.
                """;

        do {
            System.out.println("Primeiro crie os items do pedido.");
            System.out.println(optionsView);
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    try {
                        System.out.println("** O produto precisa estar cadastrado na loja **");
                        System.out.println("Nome do produto: ");
                        String productName = scanner.nextLine();
                        System.out.println("Quantidade: ");
                        int productQuantity = scanner.nextInt();
                        Product product = store.getProductByName(productName);
                        OrderItem orderItem = new OrderItem(product, productQuantity, product.getUnitPrice());
                        orderItems.add(orderItem);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao criar um item.");
                    }
                    break;
                case 0:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (loop);

        return orderItems;
    }

    private static void seed(Store store) {
        Customer customer01 = new Customer("Customer 01", "customer 01 Address");
        Customer customer02 = new Customer("Customer 02", "customer 02 Address");
        Customer customer03 = new Customer("Customer 03", "customer 03 Address");
        Customer customer04 = new Customer("Customer 04", "customer 04 Address");
        Product product01 = new Product("Product 01", "Product 01 description", 100d);
        Product product02 = new Product("Product 02", "Product 02 description", 19.99);
        Product product03 = new Product("Product 03", "Product 03 description", 59.90);
        Product product04 = new Product("Product 04", "Product 04 description", 99.99);
        OrderItem orderItem01 = new OrderItem(product01, 10, product01.getUnitPrice());
        OrderItem orderItem02 = new OrderItem(product02, 5, product02.getUnitPrice());
        OrderItem orderItem03 = new OrderItem(product03, 3, product03.getUnitPrice());
        OrderItem orderItem04 = new OrderItem(product03, 4, product03.getUnitPrice());
        OrderItem orderItem05 = new OrderItem(product02, 7, product02.getUnitPrice());

        store.addCustomer(customer01);
        store.addCustomer(customer02);
        store.addCustomer(customer03);
        store.addCustomer(customer04);

        store.addProduct(product01);
        store.addProduct(product02);
        store.addProduct(product03);
        store.addProduct(product04);

        store.createSimpleOrder(customer01, List.of(orderItem01, orderItem02));
        store.createSimpleOrder(customer02, List.of(orderItem01, orderItem02, orderItem04));
        store.createSimpleOrder(customer03, List.of(orderItem03));
        store.createSimpleOrder(customer04, List.of(orderItem05, orderItem02, orderItem01, orderItem04));

        store.createExpressOrder(customer01, List.of(orderItem01, orderItem02, orderItem05), 29.90);
        store.createExpressOrder(customer02, List.of(orderItem01, orderItem02, orderItem03), 35d);
        store.createExpressOrder(customer03, List.of(orderItem02, orderItem03), 52.41);
        store.createExpressOrder(customer04, List.of(orderItem05, orderItem04), 74d);
    }
}
