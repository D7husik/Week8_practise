package exercise3.controller;

import exercise3.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id) {
        String name = productService.getProductName(id);
        if (name == null) {
            return "Product not found";
        }
        return name;
    }

    @GetMapping("/{id}/price")
    public String getProductWithPrice(
            @PathVariable Long id,
            @RequestParam int price) {
        return productService.getProductWithPrice(id, price);
    }

    @GetMapping("/{id}/discount")
    public int getDiscountedPrice(
            @PathVariable Long id,
            @RequestParam int price) {
        return productService.getDiscountedPrice(id, price);
    }
}
