package notification.confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class NotificationConfig {

    @Bean
    public List<String> activeChannels() {
        return List.of("EMAIL", "SMS", "PUSH");
    }

    @Bean
    public NotificationSettings notificationSettings() {
        NotificationSettings settings = new NotificationSettings();
        settings.setMaxRetries(3);
        settings.setRetryDelayMs(1000);
        settings.setEnableLogging(true);
        return settings;
    }
}
