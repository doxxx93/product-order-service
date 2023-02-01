package com.example.productorderservice.payment;

import com.example.productorderservice.payment.application.service.PaymentRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class PaymentSteps {
    public static PaymentRequest newPaymentRequest() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }

    static ExtractableResponse<Response> paymentRequest(final PaymentRequest request) {
        return RestAssured
                .given()
                .log().all()
                .body(request)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/payments")
                .then()
                .log().all()
                .extract();
    }
}
