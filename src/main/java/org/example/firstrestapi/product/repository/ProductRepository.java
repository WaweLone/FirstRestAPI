package org.example.firstrestapi.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.firstrestapi.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
