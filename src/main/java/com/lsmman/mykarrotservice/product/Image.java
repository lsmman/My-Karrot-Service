package com.lsmman.mykarrotservice.product;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "image")
@Entity
@Getter
@ToString
public class Image {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;
}