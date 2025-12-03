package exercise6;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;


@Component
@Scope("singleton") // For comparison
public class SingletonTrace {
    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
