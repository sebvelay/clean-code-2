package smells.duplicatemethod;

import java.math.BigDecimal;

public class Payment {
    private final String paymentId;

    private final BigDecimal amount;

    private final String status;
    private final Order order;

    public Payment(final String paymentId, final BigDecimal amount, final String status, final Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = status;
        this.order = order;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Order getOrder() {
        return order;
    }

    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", orderId=" + order.getOrderId() +
                '}';
    }
}
