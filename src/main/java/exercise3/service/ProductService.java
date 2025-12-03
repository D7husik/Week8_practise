package exercise3.service;



import org.springframework.stereotype.Service;

import exercise3.confiq.DiscountPolicy;
import exercise3.repository.InMemoryProductRepository;
@Service
public class ProductService {

    private final InMemoryProductRepository productRepository;
    private final DiscountPolicy discountPolicy;


    public ProductService(
            InMemoryProductRepository productRepository,
            DiscountPolicy discountPolicy) {
        this.productRepository = productRepository;
        this.discountPolicy = discountPolicy;
    }

    public String getProductName(Long id) {
        return productRepository.findNameById(id);
    }

    public int getDiscountedPrice(Long id, int originalPrice) {
        String productName = getProductName(id);
        if (productName == null) {
            throw new RuntimeException("Product not found: " + id);
        }

        int discountedPrice = discountPolicy.apply(originalPrice);
        System.out.println("Original price: $" + originalPrice);
        System.out.println("Discounted price: $" + discountedPrice);
        return discountedPrice;
    }

    public String getProductWithPrice(Long id, int originalPrice) {
        String name = getProductName(id);
        int finalPrice = discountPolicy.apply(originalPrice);
        return name + " - Original: $" + originalPrice +
                ", Discounted: $" + finalPrice;
    }
}
