package classesInterfaces.marketable;

import classesInterfaces.marketable.exceptions.NotAvailableHoursException;

public class Service implements Marketable {
    private final String serviceName;
    private final String description;
    private double hourlyPrice;
    private int availableHours;

    public Service(String serviceName, String description, double hourlyPrice, int availableHours) {
        this.serviceName = serviceName;
        this.description = description;
        this.hourlyPrice = hourlyPrice;
        this.availableHours = availableHours;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        if (quantity > availableHours)
            throw new NotAvailableHoursException("Not Available hours!");

        return hourlyPrice * quantity;
    }

    @Override
    public double applyDiscount(double discount) {
        return hourlyPrice - (hourlyPrice * discount);
    }

}
