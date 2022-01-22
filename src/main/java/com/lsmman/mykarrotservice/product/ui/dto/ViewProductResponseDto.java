package com.lsmman.mykarrotservice.product.ui.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ViewProductResponseDto {
    private String userShortAddress;
    private List<ProductResponseDto> productDtoList;
}
