package exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceField {

    @Autowired
    private PaymentService paymentService;

    public void placeOrder(String user, int amount) {
        System.out.println("Processing order...");
        paymentService.pay(user, amount);
    }
}
