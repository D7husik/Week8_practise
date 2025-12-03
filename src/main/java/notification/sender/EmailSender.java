package notification.sender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailSender")
public class EmailSender implements MessageSender {

    @Override
    public String getChannelType() {
        return "EMAIL";
    }

    @Override
    public void send(String to, String message, String notificationId) {
        System.out.println("📧 [" + notificationId + "] EMAIL to " + to + ": " + message);
    }
}
