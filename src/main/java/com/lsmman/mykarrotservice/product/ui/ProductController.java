package com.lsmman.mykarrotservice.product.ui;

import com.lsmman.mykarrotservice.member.CustomUserDetail;
import com.lsmman.mykarrotservice.product.application.ProductRestApiController;
import com.lsmman.mykarrotservice.product.ui.dto.ViewProductDetailResponseDto;
import com.lsmman.mykarrotservice.product.ui.dto.ViewProductResponseDto;
import com.lsmman.mykarrotservice.product.ui.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.View;
import java.io.IOException;
import java.util.List;

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
        System.out.println(registerProductRequestDto);
        registerProductRequestDto.setMember(userDetail.getMember());
        productRestController.createProduct(registerProductRequestDto, file);
        // TODO restController 호출시 RestTemplate 적용
        return "redirect:/product/view";
    }

    @GetMapping("/view")
    public String viewProduct(
            @AuthenticationPrincipal CustomUserDetail userDetail,
            Model model
    ){
        ViewProductResponseDto responseDto = new ViewProductResponseDto();
        responseDto.setProductDtoList(productRestController.readProducts());
        responseDto.setUserShortAddress(userDetail.getMember().getShortAddress());
        model.addAttribute("responseDto", responseDto);
        return "viewProductList";
    }

    @GetMapping("/view/{productId}")
    public String viewProductDetail(
            @AuthenticationPrincipal CustomUserDetail userDetail,
            Model model,
            @PathVariable Long productId
    ){
        ViewProductDetailResponseDto viewProductDetailResponseDto = null;
        model.addAttribute("data", viewProductDetailResponseDto);
        return "viewProductDetail";
    }

}
