package inheritance;

import java.util.Objects;

public class Product {
    private final String productName;
    private final String description;
    private double unitPrice;

    public Product(String productName, String description, double unitPrice) {
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(unitPrice, product.unitPrice) == 0 && Objects.equals(productName, product.productName)
                && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, description, unitPrice);
    }

    @Override
    public String toString() {
        return this.productName + ' ' + this.description + ' ' + this.unitPrice;
    }
}
