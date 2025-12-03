package exercise6;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RequestScopeDemo implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("REQUEST SCOPE DEMONSTRATION");
        System.out.println("=".repeat(70));
        System.out.println("""
            
            Request-scoped beans are created once per HTTP request.
            
             TEST IT:
            1. Open browser and go to: http://localhost:8080/request-id
            2. Refresh multiple times - notice the ID CHANGES each time
            3. Compare with: http://localhost:8080/compare-scopes
            4. The singleton ID stays the same, request ID changes
            
             ENDPOINTS:
            • GET /request-id - Simple request ID
            • GET /request-info - Request ID with timestamp
            • GET /request-detailed - Full request details
            • GET /request-multiple-calls - Multiple calls in same request
            • GET /compare-scopes - Compare request vs singleton
            
             OBSERVE:
            - Each HTTP request gets a NEW RequestTrace instance
            - Within same request, multiple calls use SAME instance
            - Different browser tabs = different requests = different IDs
            """);
        System.out.println("=".repeat(70) + "\n");
    }
}
