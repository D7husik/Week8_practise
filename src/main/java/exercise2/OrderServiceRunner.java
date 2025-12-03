package exercise2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceRunner implements CommandLineRunner {

    private final OrderServiceConstructor orderService;

    public OrderServiceRunner(OrderServiceConstructor orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Testing Order Service ===");
        orderService.placeOrder("john@example.com", 150);
    }
}
