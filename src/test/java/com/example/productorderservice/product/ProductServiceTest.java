package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품을 등록한다.")
    void addProduct() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);
    }
}
