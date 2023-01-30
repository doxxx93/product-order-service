package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

class Product {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;
    private Long id;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        assertThat(name).isNotBlank().describedAs("상품명은 필수입니다.");
        assertThat(price).isGreaterThan(0).describedAs("상품 가격은 0보다 커야 합니다.");
        assertThat(discountPolicy).isNotNull().describedAs("할인 정책은 필수입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
