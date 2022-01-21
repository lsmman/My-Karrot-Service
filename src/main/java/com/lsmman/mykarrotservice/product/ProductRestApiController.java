package com.lsmman.mykarrotservice.product;

import com.lsmman.mykarrotservice.product.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}
