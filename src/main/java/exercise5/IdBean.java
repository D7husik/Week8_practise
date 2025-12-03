package exercise5;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.UUID;



@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
// @Scope("singleton")
public class IdBean {
    private final String id = UUID.randomUUID().toString();
    private int counter = 0;

    public IdBean() {
        System.out.println("🏗️ Creating IdBean with ID: " + id);
    }

    public String getId() {
        return id;
    }

    public int incrementAndGet() {
        return ++counter;
    }

    public int getCounter() {
        return counter;
    }
}
