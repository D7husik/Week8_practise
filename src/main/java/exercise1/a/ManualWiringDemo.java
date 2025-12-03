package exercise1.a;

public class ManualWiringDemo {
    public static void main(String[] args) {
        System.out.println("=== Using Email Sender ===");
        MessageSender emailSender = new EmailMessageSender();
        NotificationService notificationService = new NotificationService(emailSender);
        notificationService.notifyUser("user@example.com", "Welcome!");

        System.out.println("\n=== Using SMS Sender ===");
        MessageSender smsSender = new SmsMessageSender();
        NotificationService smsNotificationService = new NotificationService(smsSender);
        smsNotificationService.notifyUser("user@example.com", "Welcome!");
    }
}