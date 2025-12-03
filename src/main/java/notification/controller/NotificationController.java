package notification.controller;


import notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/simple")
    public Map<String, String> sendSimple(
            @RequestParam String user,
            @RequestParam String message) {
        String notifId = notificationService.sendEmail(user, message);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("channel", "EMAIL");
        response.put("notificationId", notifId);
        response.put("recipient", user);
        return response;
    }

    @PostMapping("/all")
    public Map<String, Object> sendToAll(
            @RequestParam String user,
            @RequestParam String message) {
        List<String> notifIds = notificationService.sendToAllChannels(user, message);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("channels", notificationService.getActiveChannels());
        response.put("notificationIds", notifIds);
        response.put("recipient", user);
        response.put("count", notifIds.size());
        return response;
    }

    @PostMapping("/channel/{channel}")
    public Map<String, String> sendByChannel(
            @PathVariable String channel,
            @RequestParam String user,
            @RequestParam String message) {
        String notifId = notificationService.sendByChannel(channel, user, message);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("channel", channel.toUpperCase());
        response.put("notificationId", notifId);
        response.put("recipient", user);
        return response;
    }

    @GetMapping("/channels")
    public Map<String, Object> getChannels() {
        Map<String, Object> response = new HashMap<>();
        response.put("activeChannels", notificationService.getActiveChannels());
        response.put("count", notificationService.getActiveChannels().size());
        return response;
    }

    @GetMapping("/settings")
    public Map<String, Object> getSettings() {
        var settings = notificationService.getSettings();
        Map<String, Object> response = new HashMap<>();
        response.put("maxRetries", settings.getMaxRetries());
        response.put("retryDelayMs", settings.getRetryDelayMs());
        response.put("loggingEnabled", settings.isEnableLogging());
        return response;
    }
}




