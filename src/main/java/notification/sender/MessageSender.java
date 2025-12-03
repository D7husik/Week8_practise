package notification.sender;

public interface MessageSender {
    String getChannelType();
    void send(String to, String message, String notificationId);
}