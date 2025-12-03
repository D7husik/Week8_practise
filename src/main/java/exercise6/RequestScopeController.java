package exercise6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RequestScopeController {

    private final RequestTrace requestTrace;
    private final RequestScopedService service;
    private final RequestMetadata metadata;

    public RequestScopeController(
            RequestTrace requestTrace,
            RequestScopedService service,
            RequestMetadata metadata) {
        this.requestTrace = requestTrace;
        this.service = service;
        this.metadata = metadata;
    }

    @GetMapping("/request-id")
    public String id() {
        return requestTrace.getRequestId();
    }

    @GetMapping("/request-info")
    public String info() {
        return requestTrace.getInfo();
    }

    @GetMapping("/request-detailed")
    public String detailed(HttpServletRequest request) {

        metadata.setUserAgent(request.getHeader("User-Agent"));
        metadata.setRemoteAddr(request.getRemoteAddr());

        return service.getDetailedInfo();
    }

    @GetMapping("/request-multiple-calls")
    public String multipleCalls() {

        String id1 = requestTrace.getRequestId();
        String id2 = requestTrace.getRequestId();
        String id3 = requestTrace.getRequestId();

        return String.format(
                "Called 3 times:\n1. %s\n2. %s\n3. %s\nAll same? %b",
                id1, id2, id3,
                id1.equals(id2) && id2.equals(id3)
        );
    }
}
