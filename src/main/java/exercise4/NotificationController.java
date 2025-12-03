package exercise4;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/email")
    public String notifyByEmail(
            @RequestParam String user,
            @RequestParam String message) {
        notificationService.notifyByEmail(user, message);
        return "Email notification sent to " + user;
    }

    @PostMapping("/sms")
    public String notifyBySms(
            @RequestParam String user,
            @RequestParam String message) {
        notificationService.notifyBySms(user, message);
        return "SMS notification sent to " + user;
    }

    @PostMapping("/push")
    public String notifyByPush(
            @RequestParam String user,
            @RequestParam String message) {
        notificationService.notifyByPush(user, message);
        return "Push notification sent to " + user;
    }

    @PostMapping("/all")
    public String notifyAll(
            @RequestParam String user,
            @RequestParam String message) {
        notificationService.notifyAll(user, message);
        return "Notifications sent via all channels to " + user;
    }
}
