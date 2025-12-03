package notification.service;


import notification.NotificationIdGenerator;
import notification.confiq.NotificationSettings;
import notification.sender.MessageSender;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    private final MessageSender emailSender;
    private final MessageSender smsSender;
    private final MessageSender pushSender;
    private final List<String> activeChannels;
    private final NotificationSettings settings;
    private final ApplicationContext context;

    public NotificationService(
            @Qualifier("emailSender") MessageSender emailSender,
            @Qualifier("smsSender") MessageSender smsSender,
            @Qualifier("pushSender") MessageSender pushSender,
            List<String> activeChannels,
            NotificationSettings settings,
            ApplicationContext context) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.pushSender = pushSender;
        this.activeChannels = activeChannels;
        this.settings = settings;
        this.context = context;
    }

    private String generateNotificationId() {
        NotificationIdGenerator generator = context.getBean(NotificationIdGenerator.class);
        return generator.getId();
    }

    public String sendEmail(String to, String message) {
        if (!activeChannels.contains("EMAIL")) {
            return "Email channel is not active";
        }
        String notifId = generateNotificationId();
        log("Sending email notification: " + notifId);
        emailSender.send(to, message, notifId);
        return notifId;
    }

    public String sendSms(String to, String message) {
        if (!activeChannels.contains("SMS")) {
            return "SMS channel is not active";
        }
        String notifId = generateNotificationId();
        log("Sending SMS notification: " + notifId);
        smsSender.send(to, message, notifId);
        return notifId;
    }

    public String sendPush(String to, String message) {
        if (!activeChannels.contains("PUSH")) {
            return "Push channel is not active";
        }
        String notifId = generateNotificationId();
        log("Sending push notification: " + notifId);
        pushSender.send(to, message, notifId);
        return notifId;
    }

    public List<String> sendToAllChannels(String to, String message) {
        List<String> notificationIds = new java.util.ArrayList<>();

        log("Sending notification via all active channels");

        if (activeChannels.contains("EMAIL")) {
            notificationIds.add(sendEmail(to, message));
        }
        if (activeChannels.contains("SMS")) {
            notificationIds.add(sendSms(to, message));
        }
        if (activeChannels.contains("PUSH")) {
            notificationIds.add(sendPush(to, message));
        }

        return notificationIds;
    }

    public String sendByChannel(String channel, String to, String message) {
        return switch (channel.toUpperCase()) {
            case "EMAIL" -> sendEmail(to, message);
            case "SMS" -> sendSms(to, message);
            case "PUSH" -> sendPush(to, message);
            default -> throw new IllegalArgumentException("Unknown channel: " + channel);
        };
    }

    private void log(String message) {
        if (settings.isEnableLogging()) {
            System.out.println("📋 [NotificationService] " + message);
        }
    }

    public List<String> getActiveChannels() {
        return activeChannels;
    }

    public NotificationSettings getSettings() {
        return settings;
    }
}
