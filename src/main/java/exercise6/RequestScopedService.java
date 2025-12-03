package exercise6;


import org.springframework.stereotype.Service;

@Service
public class RequestScopedService {

    private final RequestTrace requestTrace;
    private final RequestMetadata metadata;


    public RequestScopedService(
            RequestTrace requestTrace,
            RequestMetadata metadata) {
        this.requestTrace = requestTrace;
        this.metadata = metadata;
        System.out.println("🔧 RequestScopedService created");
    }

    public String getRequestInfo() {
        return "Request ID: " + requestTrace.getRequestId() +
                " | Session: " + metadata.getSessionId();
    }

    public String getDetailedInfo() {
        return String.format(
                "Request: %s\nSession: %s\nTimestamp: %s\nUser-Agent: %s\nIP: %s",
                requestTrace.getRequestId(),
                metadata.getSessionId(),
                requestTrace.getTimestamp(),
                metadata.getUserAgent(),
                metadata.getRemoteAddr()
        );
    }
}
