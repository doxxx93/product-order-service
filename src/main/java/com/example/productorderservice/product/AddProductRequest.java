package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

    AddProductRequest {
        assertThat(name).isNotBlank().describedAs("상품명은 필수입니다.");
        assertThat(price).isGreaterThan(0).describedAs("상품 가격은 0보다 커야 합니다.");
        assertThat(discountPolicy).isNotNull().describedAs("할인 정책은 필수입니다.");
    }
}
