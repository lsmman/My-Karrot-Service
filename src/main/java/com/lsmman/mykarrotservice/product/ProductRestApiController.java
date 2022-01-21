package com.lsmman.mykarrotservice.product;

import com.lsmman.mykarrotservice.product.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/api")
@RequiredArgsConstructor
public class ProductRestApiController {
    private final ProductService productService;

    @PutMapping
    public ResponseEntity<?> createProduct(@RequestBody RegisterProductRequestDto registerProductRequestDto) {
        productService.createProduct(RegisterProductRequestDto.toProduct(registerProductRequestDto));
        return ResponseEntity.ok().build();
    }
}
