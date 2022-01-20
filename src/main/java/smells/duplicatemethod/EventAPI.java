package smells.duplicatemethod;

public class EventAPI {

    MessagingClient messagingClient;

    public EventAPI(final MessagingClient messagingClient) {
        this.messagingClient = messagingClient;
    }

    public void newPayment(Payment t) {
        messagingClient.sendMessage(new Message(t.toString(), t.getPaymentId()));
    }

    public void newOrder(Order t) {
        messagingClient.sendMessage(new Message(t.toString(), t.getOrderId()));
    }

}
