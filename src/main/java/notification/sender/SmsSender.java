package notification.sender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsSender")
public class SmsSender implements MessageSender {

    @Override
    public String getChannelType() {
        return "SMS";
    }

    @Override
    public void send(String to, String message, String notificationId) {
        System.out.println("📱 [" + notificationId + "] SMS to " + to + ": " + message);
    }
}
