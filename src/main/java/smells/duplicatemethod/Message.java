package smells.duplicatemethod;

public class Message {
    private String body;

    private String key;

    public Message(final String body, final String key) {
        this.body = body;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body=" + body +
                ", key='" + key + '\'' +
                '}';
    }


}
