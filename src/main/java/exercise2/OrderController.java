package exercise2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceConstructor orderService;

    public OrderController(OrderServiceConstructor orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(
            @RequestParam String user,
            @RequestParam int amount) {
        orderService.placeOrder(user, amount);
        return "Order placed successfully for " + user;
    }
}