package com.lsmman.mykarrotservice.product.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT * FROM product p ORDER BY p.create_at LIMIT 4",
            nativeQuery = true
    )
    List<Product> findAllOrderByDateWithLimit4();
}
