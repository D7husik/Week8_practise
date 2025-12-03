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
public class RequestMetadata {
    private final String sessionId;
    private String userAgent;
    private String remoteAddr;

    public RequestMetadata() {
        this.sessionId = UUID.randomUUID().toString().substring(0, 8);
        System.out.println("📝 Created RequestMetadata: " + sessionId);
    }


    public String getSessionId() { return sessionId; }
    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
    public String getRemoteAddr() { return remoteAddr; }
    public void setRemoteAddr(String remoteAddr) { this.remoteAddr = remoteAddr; }
}

