package com.lsmman.mykarrotservice.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DealStatus {
    SELLING("판매중"),
    FINISHED("거래완료"),
    RESERVED("예약중");

    private final String value;
}
