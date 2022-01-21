package com.lsmman.mykarrotservice.product;

import com.lsmman.mykarrotservice.member.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    @JoinColumn(name = "IMAGE_ID")
    private List<Image> images = new ArrayList<>();

    private int imageCount;

    private String contents;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createAt;

    @Enumerated(EnumType.STRING)
    private DealStatus dealStatus;
}
