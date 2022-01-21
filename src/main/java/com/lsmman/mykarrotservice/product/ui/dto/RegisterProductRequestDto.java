package com.lsmman.mykarrotservice.product.ui.dto;

import com.lsmman.mykarrotservice.member.Member;
import com.lsmman.mykarrotservice.product.domain.Category;
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
        return Product.builder()
                .category(requestDto.getCategory())
                .member(requestDto.getMember())
                .title(requestDto.getTitle())
                .price(requestDto.getPrice())
                .contents(requestDto.getContents())
                .imageUrl(requestDto.getFilePath())
                .build();
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
