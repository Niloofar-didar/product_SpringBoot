package com.example.product_SpringBoot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.ok("Product added successfully");
    }

    @GetMapping("/filter/price/{initialRange}/{finalRange}")
    public ResponseEntity<List<Product>> filterByPriceRange(@PathVariable double initialRange, @PathVariable double finalRange) {
        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getPrice() >= initialRange && product.getPrice() <= finalRange)
                .collect(Collectors.toList());
        if (filteredProducts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(filteredProducts);
    }

    @GetMapping("/sort/price")
    public List<Product> sortByPrice() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
//below api is to get /api/test?name=someName&price=somePrice
@GetMapping("/api/test")
public ResponseEntity<List<Product>> search(@RequestParam String name, @RequestParam Integer price) {
    List<Product> filteredProducts = products.stream()
            .filter(product -> product.getItem().equals(name) && product.getPrice() == price)
            .collect(Collectors.toList());
    if (filteredProducts.isEmpty()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    return ResponseEntity.ok(filteredProducts);
}

}
