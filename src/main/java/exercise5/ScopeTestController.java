package exercise5;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ScopeTestController {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    public ScopeTestController(ServiceA serviceA, ServiceB serviceB) {
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    @GetMapping("/ids")
    public List<String> ids() {
        return List.of(
                serviceA.getId(),
                serviceB.getId()
        );
    }

    @GetMapping("/ids-with-counter")
    public List<String> idsWithCounter() {
        return List.of(
                serviceA.getIdWithCounter(),
                serviceB.getIdWithCounter()
        );
    }

    @GetMapping("/scope-info")
    public String scopeInfo() {
        String idA = serviceA.getId();
        String idB = serviceB.getId();

        if (idA.equals(idB)) {
            return " SINGLETON: Both services share the same IdBean instance\n" +
                    "ID: " + idA + "\n" +
                    "This bean is created ONCE and shared across the application.";
        } else {
            return " PROTOTYPE: Each service has its own IdBean instance\n" +
                    idA + "\n" + idB + "\n" +
                    "New instances are created for each injection point.";
        }
    }
}
