package exercise3.confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class PercentageDiscountPolicy implements DiscountPolicy {
    private final int percent;

    public PercentageDiscountPolicy(int percent) {
        this.percent = percent;
    }

    @Override
    public int apply(int originalPrice) {
        return originalPrice * (100 - percent) / 100;
    }

    public int getPercent() {
        return percent;
    }
}