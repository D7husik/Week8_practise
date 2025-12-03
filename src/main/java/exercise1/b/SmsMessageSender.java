package exercise1.b;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("SMS to " + to + ": " + message);
    }
}