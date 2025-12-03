package exercise4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsSender")
public class SmsSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("📱 SMS to " + to + ": " + message);
    }
}
