package exercise6;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import java.time.LocalDateTime;
import java.util.UUID;



@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestTrace {
    private final String requestId;
    private final LocalDateTime timestamp;

    public RequestTrace() {
        this.requestId = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
        System.out.println("🔄 Created RequestTrace: " + requestId +
                " at " + timestamp);
    }

    public String getRequestId() {
        return requestId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getInfo() {
        return "Request ID: " + requestId +
                " | Time: " + timestamp;
    }
}
