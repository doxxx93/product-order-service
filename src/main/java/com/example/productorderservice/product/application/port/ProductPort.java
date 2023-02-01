package com.example.productorderservice.product.application.port;

import com.example.productorderservice.product.domain.Product;

public interface ProductPort {
    /**
     * 구현은 Adapter에서 한다.
     *
     * @param product 상품
     */
    void save(final Product product);

    Product getProduct(Long productId);
}
