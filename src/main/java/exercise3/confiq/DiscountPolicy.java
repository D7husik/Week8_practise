package exercise3.confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public interface DiscountPolicy {
    int apply(int originalPrice);
}