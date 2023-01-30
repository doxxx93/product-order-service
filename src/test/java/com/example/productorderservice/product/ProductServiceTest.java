package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductServiceTest {
    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
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

    private class ProductService {
        private final ProductPort productPort;

        private ProductService(final ProductPort productPort) {
            this.productPort = productPort;
        }

        public void addProduct(final AddProductRequest request) {
            final Product product = new Product(request.name, request.price, request.discountPolicy);
            productPort.save(product);
        }
    }

    private record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

        private AddProductRequest {
            assertThat(name).isNotBlank().describedAs("상품명은 필수입니다.");
            assertThat(price).isGreaterThan(0).describedAs("상품 가격은 0보다 커야 합니다.");
            assertThat(discountPolicy).isNotNull().describedAs("할인 정책은 필수입니다.");
        }
    }

    private enum DiscountPolicy {
        NONE
    }

    private class Product {
        private Long id;
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

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

    private interface ProductPort {
        /**
         * 구현은 Adapter에서 한다.
         *
         * @param product 상품
         */
        public void save(final Product product);
    }

    private class ProductAdapter implements ProductPort {
        private final ProductRepository productRepository;

        private ProductAdapter(final ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private Map<Long, Product> persistence = new HashMap<>();
        private Long sequence = 0L;

        public void save(final Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
