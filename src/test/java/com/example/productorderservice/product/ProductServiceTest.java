package com.example.productorderservice.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품을 등록한다.")
    void addProduct() {
        final AddProductRequest request = getAddProductRequest();

        productService.addProduct(request);
    }

    private static AddProductRequest getAddProductRequest() {
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        return new AddProductRequest(name, price, discountPolicy);
    }
}
