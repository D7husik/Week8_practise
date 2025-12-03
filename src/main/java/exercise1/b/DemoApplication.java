package exercise1.b;

//import com.example.exercise1.b.NotificationService;
//import com.example.exercise1.b.NotificationService;
//import com.example.*.not

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final NotificationService notificationService;

    public DemoApplication(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("\n=== Spring IoC Demo ===");
        notificationService.notifyUser("user@example.com", "Welcome from Spring!");
    }
}
