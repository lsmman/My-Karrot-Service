package com.lsmman.mykarrotservice.product.application;

import com.lsmman.mykarrotservice.product.domain.Product;
import com.lsmman.mykarrotservice.product.ui.dto.ProductResponseDto;
import com.lsmman.mykarrotservice.product.ui.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product/api")
@RequiredArgsConstructor
public class ProductRestApiController {
    private final ProductService productService;
    private final S3Service s3Service;

    @PutMapping
    public ResponseEntity<?> createProduct(@RequestBody RegisterProductRequestDto registerProductRequestDto,
                                           @RequestBody MultipartFile file) throws IOException {

        String imgPath = s3Service.upload(file);
        registerProductRequestDto.setFilePath(imgPath);

        productService.saveProduct(RegisterProductRequestDto.toProduct(registerProductRequestDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<ProductResponseDto> readProducts() {
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        List<Product> productList = productService.getProductListOrderByDateWithLimit4();
        if (productList.isEmpty()){
            return new ArrayList<>();
        }
        for (Product product : productList) {
            productResponseDtoList.add(ProductResponseDto.fromProduct(product));
        }
        return productResponseDtoList;
    }

}
