package exercise3.confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountConfig {

    @Bean
    public DiscountPolicy discountPolicy() {
        return new PercentageDiscountPolicy(10); // 10% discount
    }

    @Bean
    public String storeName() {
        return "Spring Electronics Shop";
    }
}