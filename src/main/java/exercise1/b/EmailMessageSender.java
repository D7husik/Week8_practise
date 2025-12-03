package exercise1.b;

import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("EMAIL to " + to + ": " + message);
    }
}
