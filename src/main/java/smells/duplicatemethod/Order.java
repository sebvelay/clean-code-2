package smells.duplicatemethod;

import java.util.Set;

public class Order {
    private final String orderId;

    private final String orderReference;

    private final Set<String> items;

    public Order(final String orderId, final String orderReference, final Set<String> items) {
        this.orderId = orderId;
        this.orderReference = orderReference;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public Set<String> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderReference='" + orderReference + '\'' +
                ", items=" + items +
                '}';
    }
}
