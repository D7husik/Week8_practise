package exercise4;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class NotificationApiController {

    private final NotificationService notificationService;

    public NotificationApiController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/email")
    public String notifyByEmail(@RequestBody NotificationRequest request) {
        notificationService.notifyByEmail(request.getUser(), request.getMessage());
        return "Email sent";
    }

    @PostMapping("/sms")
    public String notifyBySms(@RequestBody NotificationRequest request) {
        notificationService.notifyBySms(request.getUser(), request.getMessage());
        return "SMS sent";
    }

    @PostMapping("/all")
    public String notifyAll(@RequestBody NotificationRequest request) {
        notificationService.notifyAll(request.getUser(), request.getMessage());
        return "All notifications sent";
    }
}
