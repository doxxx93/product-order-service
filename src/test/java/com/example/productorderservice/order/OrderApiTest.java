package com.example.productorderservice.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class OrderApiTest extends ApiTest {
    @Test
    @DisplayName("주문을 생성한다.")
    void createOrder() {
        ProductSteps.addProductRequest(ProductSteps.newAddProductRequest());

        final var request = OrderSteps.newCreateOrderRequest();

        final var response = OrderSteps.createOrderRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
