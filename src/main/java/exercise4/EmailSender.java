package exercise4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailSender")
public class EmailSender implements MessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("📧 Email to " + to + ": " + message);
    }
}
