package com.lsmman.mykarrotservice.product.domain;

import com.lsmman.mykarrotservice.member.Member;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@AllArgsConstructor
@Builder

public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    private String title;

    private int price;

    private int commentCount;

    private int likeCount;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Enumerated(EnumType.STRING)
    private Category category;

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "product")
//    private List<Image> images = new ArrayList<>();
//    private int imageCount;

    private String imageUrl;

    private String contents;

    @Enumerated(EnumType.STRING)
    private DealStatus dealStatus;

    private String shortAddress;

    @CreationTimestamp
    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    public String getShortAddress() {
        if (Objects.isNull(shortAddress) || shortAddress.isEmpty()) {
            shortAddress = member.getShortAddress();
        }
        return shortAddress;
    }
}
