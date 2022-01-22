package com.lsmman.mykarrotservice.product.ui.dto;

import com.lsmman.mykarrotservice.member.Member;
import com.lsmman.mykarrotservice.product.domain.Category;
import com.lsmman.mykarrotservice.product.domain.DealStatus;
import com.lsmman.mykarrotservice.product.domain.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterProductRequestDto {
    private Member member;
    private String filePath;
    private String title;
    private Category category;
    private int price;
    private String contents;

    public static Product toProduct(RegisterProductRequestDto requestDto) {
        // TODO toProduct에서 기본 값을 정하지 말고 Product 생성자로 객체지향적으로 바꾸기
        return Product.builder()
                .title(requestDto.getTitle())
                .price(requestDto.getPrice())
                .commentCount(0)
                .likeCount(0)
                .member(requestDto.getMember())
                .category(requestDto.getCategory())
                .imageUrl(requestDto.getFilePath())
                .contents(requestDto.getContents())
                .dealStatus(DealStatus.SELLING)
                .shortAddress("삼산1동")
                .build();
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
