package com.lsmman.mykarrotservice.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT * FROM Product p ORDER BY p.create_at",
            nativeQuery = true
    ) // TODO Limit 구현
    List<Product> findAllOrderByDateWithLimit4();
}
