package exercise1.b;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String user, String message) {
        sender.send(user, message);
    }
}