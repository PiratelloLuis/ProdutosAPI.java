package io.github.piratelloluis.produtosapi.repository;

import io.github.piratelloluis.produtosapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, String> {



}
