package com.example.productorderservice.product;

interface ProductPort {
    /**
     * 구현은 Adapter에서 한다.
     *
     * @param product 상품
     */
    void save(final Product product);
}
