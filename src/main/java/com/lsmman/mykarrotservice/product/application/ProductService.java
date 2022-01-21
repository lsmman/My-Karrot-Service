package com.lsmman.mykarrotservice.product.application;

import com.lsmman.mykarrotservice.product.domain.Product;
import com.lsmman.mykarrotservice.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
