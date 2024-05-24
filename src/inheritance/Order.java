package inheritance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Order {
    UUID getId();

    Customer getClient();

    LocalDateTime getOrderDate();

    List<OrderItem> getItems();

    double getTotalValue();

    double getTotalValue(double discount);

    double applyDiscount(double discount);
}
