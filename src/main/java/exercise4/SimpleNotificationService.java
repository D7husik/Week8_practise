package exercise4;
import org.springframework.stereotype.Service;

@Service
public class SimpleNotificationService {

    private final MessageSender defaultSender;


    public SimpleNotificationService(MessageSender defaultSender) {
        this.defaultSender = defaultSender;
    }

    public void notify(String user, String message) {
        defaultSender.send(user, message);
    }
}
