package com.lsmman.mykarrotservice.product.application;

import com.lsmman.mykarrotservice.product.domain.Product;
import com.lsmman.mykarrotservice.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProductListOrderByDateWithLimit4() {
        List<Product> productList = productRepository.findAllOrderByDateWithLimit4();
        if (Objects.isNull(productList) || productList.isEmpty()){
            return new ArrayList<>();
        }
        return productList;
    }
}
