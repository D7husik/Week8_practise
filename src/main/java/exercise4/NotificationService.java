package exercise4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final MessageSender emailSender;
    private final MessageSender smsSender;
    private final MessageSender pushSender;


    public NotificationService(
            @Qualifier("emailSender") MessageSender emailSender,
            @Qualifier("smsSender") MessageSender smsSender,
            @Qualifier("pushNotificationSender") MessageSender pushSender) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.pushSender = pushSender;
    }

    public void notifyByEmail(String user, String message) {
        emailSender.send(user, message);
    }

    public void notifyBySms(String user, String message) {
        smsSender.send(user, message);
    }

    public void notifyByPush(String user, String message) {
        pushSender.send(user, message);
    }

    public void notifyAll(String user, String message) {
        emailSender.send(user, message);
        smsSender.send(user, message);
        pushSender.send(user, message);
    }
}
