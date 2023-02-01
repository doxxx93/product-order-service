package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    @DisplayName("할인 정책이 없는 경우 할인 금액은 기존과 동일하다.")
    void applyNoneDiscount() {
        final int price = 1000;

        final int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    @DisplayName("정액 할인 정책의 제품 가격은 원래 가격에서 할인 금액을 뺀 가격이다.")
    void applyFixedDiscount() {
        final int price = 2000;

        final int discountedPrice = DiscountPolicy.FIXED_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(1000);
    }
}
