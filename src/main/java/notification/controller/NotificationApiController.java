package notification.controller;




import notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import notification.service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/notify")
public class NotificationApiController {

    private final NotificationService notificationService;

    public NotificationApiController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Map<String, Object> sendNotification(@RequestBody NotificationRequest request) {
        List<String> notifIds;

        if (request.getChannels() == null || request.getChannels().isEmpty()) {
            notifIds = notificationService.sendToAllChannels(
                    request.getRecipient(),
                    request.getMessage()
            );
        } else {
            notifIds = new java.util.ArrayList<>();
            for (String channel : request.getChannels()) {
                String id = notificationService.sendByChannel(
                        channel,
                        request.getRecipient(),
                        request.getMessage()
                );
                notifIds.add(id);
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("notificationIds", notifIds);
        response.put("recipient", request.getRecipient());
        return response;
    }
}

