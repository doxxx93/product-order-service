package com.example.productorderservice.order;

import com.example.productorderservice.product.ProductService;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("주문을 생성한다.")
    void createOrder() {
        productService.addProduct(ProductSteps.newAddProductRequest());
        final CreateOrderRequest request = newCreateOrderRequest();

        orderService.createOrder(request);
    }

    private static CreateOrderRequest newCreateOrderRequest() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}
