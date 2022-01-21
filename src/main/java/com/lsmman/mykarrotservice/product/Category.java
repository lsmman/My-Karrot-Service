package com.lsmman.mykarrotservice.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    DIGITAL("디지털기기"),
    HOME_APPLIANCE("생활가전"),
    FURNITURE_INTERIOR("가구/인테리어"),
    CHILDREN("유아동"),
    LIFE_PROCESSED_FOOD("생활/가공식품"),
    CHILDRENS_BOOK("유아도서"),
    SPORTS_LEISURE("스포츠/레저"),
    WOMENS_ACCESSORIES("여성잡화"),
    WOMENS_CLOTHING("여성의류"),
    MENS_FASHION_MISCELLANEOUS_GOODS("남성패션/잡화"),
    GAMES_HOBBIES("게임/취미"),
    BEAUTY_BEAUTY("뷰티/미용"),
    PET_SUPPLIES("반려동물용품"),
    BOOKS_TICKETS_ALBUMS("도서/티켓/음반"),
    PLANTS("식물"),
    OTHER_USED_GOODS("기타 중고물품"),
    USED_CARS("중고차");

    private final String value;
}
