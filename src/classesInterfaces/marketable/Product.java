package classesInterfaces.marketable;

import classesInterfaces.marketable.exceptions.NotEnoughInventoryException;

public class Product implements Marketable {
    private final String productName;
    private final String description;
    private double unitPrice;
    private int inventory;

    public Product(String productName, String description, double unitPrice, int inventory) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        if (quantity > inventory)
            throw new NotEnoughInventoryException("Not enough inventory!");

        return unitPrice * quantity;
    }

    @Override
    public double applyDiscount(double discount) {
        return unitPrice - (unitPrice * discount);
    }
}
