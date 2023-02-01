package com.example.productorderservice.payment;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class PaymentApiTest extends ApiTest {
    @Test
    @DisplayName("주문을 결제한다.")
    void payOrder() {
        ProductSteps.addProductRequest(ProductSteps.newAddProductRequest());
        OrderSteps.createOrderRequest(OrderSteps.newCreateOrderRequest());
        final var request = PaymentSteps.newPaymentRequest();

        final var response = PaymentSteps.paymentRequest(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
