package exercise5;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScopeDemo implements CommandLineRunner {

    private final ApplicationContext context;
    private final ServiceA serviceA;
    private final ServiceB serviceB;

    public ScopeDemo(ApplicationContext context,
                     ServiceA serviceA,
                     ServiceB serviceB) {
        this.context = context;
        this.serviceA = serviceA;
        this.serviceB = serviceB;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("BEAN SCOPE DEMONSTRATION");
        System.out.println("=".repeat(60));

        System.out.println("\n📦 Testing injected beans:");
        System.out.println(serviceA.getId());
        System.out.println(serviceB.getId());

        System.out.println("\n📦 Testing manually retrieved beans:");
        IdBean bean1 = context.getBean(IdBean.class);
        IdBean bean2 = context.getBean(IdBean.class);

        System.out.println("Bean 1 ID: " + bean1.getId());
        System.out.println("Bean 2 ID: " + bean2.getId());
        System.out.println("Are they the same? " + (bean1 == bean2));

        System.out.println("\n📊 Testing state sharing:");
        System.out.println("ServiceA counter: " + serviceA.getIdWithCounter());
        System.out.println("ServiceB counter: " + serviceB.getIdWithCounter());
        System.out.println("ServiceA counter again: " + serviceA.getIdWithCounter());

        System.out.println("=".repeat(60) + "\n");
    }
}
