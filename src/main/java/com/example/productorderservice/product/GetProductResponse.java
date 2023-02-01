package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(Long id, String name, int price, DiscountPolicy discountPolicy) {

    GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.notNull(name, "상품 이름은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
    }
}
