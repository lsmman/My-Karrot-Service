package com.lsmman.mykarrotservice.product;

import com.lsmman.mykarrotservice.member.CustomUserDetail;
import com.lsmman.mykarrotservice.product.dto.RegisterProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRestApiController productRestController;
    private RestTemplate restTemplate;

    @GetMapping("/register")
    public String getRegisterProductFoam(RegisterProductRequestDto registerProductRequestDto){
        return "registerProductForm";
    }

    @PostMapping("/register")
    public String registerProduct(RegisterProductRequestDto registerProductRequestDto,
                                  @AuthenticationPrincipal CustomUserDetail userDetail){
        registerProductRequestDto.setId(userDetail.getId());
        restTemplate.put("/product/api", registerProductRequestDto);
        return "redirect/product/view";
    }

    @GetMapping("/view")
    public void viewProduct(){}

}
