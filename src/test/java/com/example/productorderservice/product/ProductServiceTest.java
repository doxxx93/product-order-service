package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
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

    private static class ProductService {
        // TODO: 2023/01/28 implement addProduct
        public void addProduct(final AddProductRequest request) {
            throw new UnsupportedOperationException("Unsupported addProduct");
        }
    }

    private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

        // TODO: 2023/01/28 refactor multiple assertions to single assertion
        private AddProductRequest {
            assertThat(name).isNotBlank().describedAs("상품명은 필수입니다.");
            assertThat(price).isGreaterThan(0).describedAs("상품 가격은 0보다 커야 합니다.");
            assertThat(discountPolicy).isNotNull().describedAs("할인 정책은 필수입니다.");
        }
    }

    private enum DiscountPolicy {
        NONE
    }
}
