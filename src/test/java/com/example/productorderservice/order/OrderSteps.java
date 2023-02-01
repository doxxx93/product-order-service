package com.example.productorderservice.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {
    public static ExtractableResponse<Response> createOrderRequest(final CreateOrderRequest request) {
        return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/orders")
                .then().log().all().extract();
    }

    public static CreateOrderRequest newCreateOrderRequest() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
