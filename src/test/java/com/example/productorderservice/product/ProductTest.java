package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.productorderservice.product.domain.DiscountPolicy;
import com.example.productorderservice.product.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ProductTest {

    @Test
    @DisplayName("상품을 수정한다.")
    void update() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("할인 정책이 없는 상품의 제품 가격은 원래 가격과 같다.")
    void getDiscountedPriceWithNoneDiscoutPolicy() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        final int discountedPrice = product.getDiscountedPrice();
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @ParameterizedTest(name = "원래 가격: {0}, 할인 금액: {1}")
    @CsvSource({"2000, 1000", "500, 0"})
    @DisplayName("정액 할인 정책의 제품 가격은 원래 가격에서 할인 금액을 뺀 가격이다.")
    void getDiscountedPriceWithFixedDiscountPolicy(int price, int discountedPrice) {
        Product product = new Product("상품명", price, DiscountPolicy.FIXED_1000_AMOUNT);
        assertThat(product.getDiscountedPrice()).isEqualTo(discountedPrice);
    }

}
