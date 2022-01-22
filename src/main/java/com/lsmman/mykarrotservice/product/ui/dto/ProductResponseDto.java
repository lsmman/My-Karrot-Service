package com.lsmman.mykarrotservice.product.ui.dto;

import com.lsmman.mykarrotservice.product.domain.DealStatus;
import com.lsmman.mykarrotservice.product.domain.Product;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {
    private Long productId;
    private String imgPath;
    private String title;
    private String shortAddress;
    private int price;
    private boolean isNotSelling;
    private String dealStatus;
    private int commentCount;
    private int likeCount;
    private String period;

    public static ProductResponseDto fromProduct(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getId())
                .imgPath(product.getImageUrl())
                .title(product.getTitle())
                .shortAddress(product.getShortAddress())
                .price(product.getPrice())
                .isNotSelling(product.getDealStatus() != DealStatus.SELLING)
                .dealStatus(product.getDealStatus().getValue())
                .commentCount(product.getCommentCount())
                .likeCount(product.getLikeCount())
                .period(product.getCreateAt().toString()) // TODO 날짜 변환기 유틸 만들기
                .build();
    }
}
