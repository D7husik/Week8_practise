package exercise1.a;

public class EmailMessageSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("EMAIL to " + to + ": " + message);
    }
}