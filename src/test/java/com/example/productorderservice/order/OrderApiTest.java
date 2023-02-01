package com.example.productorderservice.order;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class OrderApiTest extends ApiTest {
    @Test
    @DisplayName("주문을 생성한다.")
    void createOrder() {
        ProductSteps.addProductRequest(ProductSteps.newAddProductRequest());

        final CreateOrderRequest request = newCreateOrderRequest();

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/orders")
                .then().log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private static CreateOrderRequest newCreateOrderRequest() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
