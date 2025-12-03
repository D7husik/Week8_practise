package notification.sender;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pushSender")
public class PushNotificationSender implements MessageSender {

    @Override
    public String getChannelType() {
        return "PUSH";
    }

    @Override
    public void send(String to, String message, String notificationId) {
        System.out.println("🔔 [" + notificationId + "] PUSH to " + to + ": " + message);
    }
}
