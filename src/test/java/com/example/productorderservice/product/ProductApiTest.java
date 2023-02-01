package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.productorderservice.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

class ProductApiTest extends ApiTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("상품을 등록한다.")
    void addProduct() {
        final var request = ProductSteps.newAddProductRequest();

        final var response = ProductSteps.addProductRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("상품을 조회한다.")
    void getProduct() {
        ProductSteps.addProductRequest(ProductSteps.newAddProductRequest());
        Long productId = 1L;

        final var response = ProductSteps.getProductRequest(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

    @Test
    @DisplayName("상품을 수정한다.")
    void updateProduct() {
        ProductSteps.addProductRequest(ProductSteps.newAddProductRequest());
        final Long productId = 1L;

        final ExtractableResponse<Response> response = ProductSteps.updateProductRequest(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }
}
