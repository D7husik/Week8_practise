package notification;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.UUID;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NotificationIdGenerator {
    private final String id;

    public NotificationIdGenerator() {
        this.id = "NOTIF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public String getId() {
        return id;
    }
}
