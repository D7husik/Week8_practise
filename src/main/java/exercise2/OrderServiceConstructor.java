package exercise2;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceConstructor {
    private final PaymentService paymentService;

    // Constructor injection - dependencies are immutable
    public OrderServiceConstructor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(String user, int amount) {
        System.out.println("Processing order...");
        paymentService.pay(user, amount);
    }
}
