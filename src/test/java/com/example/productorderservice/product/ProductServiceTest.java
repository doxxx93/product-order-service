package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품을 조회한다.")
    void getProduct() {
        // add product
        productService.addProduct(ProductSteps.getAddProductRequest());
        final long productId = 1L;

        // get product
        final GetProductResponse response = productService.getProduct(productId);

        // assert
        assertThat(response).isNotNull();
    }
}
