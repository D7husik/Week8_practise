package exercise6;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;




@RestController
public class ScopeComparisonController {

    private final RequestTrace requestTrace;
    private final SingletonTrace singletonTrace;

    public ScopeComparisonController(
            RequestTrace requestTrace,
            SingletonTrace singletonTrace) {
        this.requestTrace = requestTrace;
        this.singletonTrace = singletonTrace;
    }

    @GetMapping("/compare-scopes")
    public String compareScopes() {
        return String.format(
                "🔄 Request-scoped ID: %s (changes each request)\n" +
                        "🔒 Singleton ID: %s (always the same)",
                requestTrace.getRequestId(),
                singletonTrace.getId()
        );
    }
}

