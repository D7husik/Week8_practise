package exercise4;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
 @Primary
public class PushNotificationSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("🔔 Push notification to " + to + ": " + message);
    }
}
