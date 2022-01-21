package com.lsmman.mykarrotservice.product.ui;

import com.lsmman.mykarrotservice.member.CustomUserDetail;
import com.lsmman.mykarrotservice.product.application.ProductRestApiController;
import com.lsmman.mykarrotservice.product.ui.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRestApiController productRestController;
//    private static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/register")
    public String getRegisterProductFoam(RegisterProductRequestDto registerProductRequestDto){
        return "registerProductForm";
    }

    @PostMapping("/register")
    public String registerProduct(RegisterProductRequestDto registerProductRequestDto,
                                  MultipartFile file,
                                  @AuthenticationPrincipal CustomUserDetail userDetail
        ) throws IOException {

        registerProductRequestDto.setMember(userDetail.getMember());
        productRestController.createProduct(registerProductRequestDto, file);
        // TODO restController 호출시 resttemplate 적용
        return "redirect:/view";
    }

    @GetMapping("/view")
    public void viewProduct(){}

}
