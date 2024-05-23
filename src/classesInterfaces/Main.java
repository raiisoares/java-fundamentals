package classesInterfaces;

import classesInterfaces.calculable.Book;
import classesInterfaces.calculable.PhysicalProduct;
import classesInterfaces.currencyConversion.CurrencyConverter;
import classesInterfaces.geometricCalculation.RectangularRoomCalculator;
import classesInterfaces.marketable.Product;
import classesInterfaces.marketable.Service;
import classesInterfaces.marketable.exceptions.NotAvailableHoursException;
import classesInterfaces.marketable.exceptions.NotEnoughInventoryException;
import classesInterfaces.multiplicationTable.MultiplicationTable;
import classesInterfaces.temperatureConverter.TemperatureConverterDefault;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        CurrencyConverter converter = new CurrencyConverter();
        double valueToBeConverted = 10d;

        System.out.println(valueToBeConverted + " Dollar(s) converted to Real is: " +
                converter.convertDollarToReal(valueToBeConverted));

        RectangularRoomCalculator roomMetricsCalculator = new RectangularRoomCalculator();
        double height = 8d;
        double width = 6.50;

        System.out.println("The area of the rectangle is " + roomMetricsCalculator.calculateArea(height, width));
        System.out.println("The perimeter of the rectangle is "
                + roomMetricsCalculator.calculatePerimeter(height, width));

        MultiplicationTable multiplicationTable = new MultiplicationTable();
        System.out.println("Multiplication Table: " + multiplicationTable.showTimesTable(5));

        TemperatureConverterDefault temperatureConverter = new TemperatureConverterDefault();
        double celsius = 27.5;
        double fahrenheit = 83.9;

        System.out.printf(celsius + "C converted to fahrenheit is: %.1fF %n",
                temperatureConverter.celsiusToFahrenheit(celsius));

        System.out.printf(fahrenheit + "F converted to celsius is: %.1fC %n",
                temperatureConverter.fahrenheitToCelsius(fahrenheit));

        Book book = new Book("Book", "Author", 30d, 0.1);
        System.out.printf("The final price of " + book.getTitle() + " is: R$%.2f %n", book.calculateFinalPrice());

        PhysicalProduct product = new PhysicalProduct("Product", "Description", 100d, 0.17, 15.95);
        System.out.printf("The final price of " + product.getProductName() + " is: R$%.2f %n",
                product.calculateFinalPrice());

        Product laptopOrder = new Product("Laptop", "Laptop description", 3000d, 5);
        double discount = 0.15;
        System.out.printf(laptopOrder.getProductName() + " price after discount is: R$%.2f %n",
                laptopOrder.applyDiscount(discount));

        try {
            System.out.printf("The total price for this order is: R$%.2f %n", laptopOrder.calculateFinalPrice(6));
        } catch (NotEnoughInventoryException err) {
            System.out.println(err.getMessage());
        }

        try {
            System.out.printf("The total price for this order is: R$%.2f %n", laptopOrder.calculateFinalPrice(2));
        } catch (NotEnoughInventoryException err) {
            System.out.println(err.getMessage());
        }

        Service freelancer = new Service("Coding", "Coding description", 200d, 30);
        double serviceDiscount = 0.10;

        System.out.printf(freelancer.getServiceName() + " price after discount is: R$%.2f %n",
                freelancer.applyDiscount(serviceDiscount));

        try {
            System.out.printf("The total price for this service is: R$%.2f %n", freelancer.calculateFinalPrice(40));
        } catch (NotAvailableHoursException err) {
            System.out.println(err.getMessage());
        }

        try {
            System.out.printf("The total price for this service is: R$%.2f %n", freelancer.calculateFinalPrice(20));
        } catch (NotAvailableHoursException err) {
            System.out.println(err.getMessage());
        }

    }
}
