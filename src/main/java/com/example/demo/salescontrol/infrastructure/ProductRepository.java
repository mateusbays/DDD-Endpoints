package com.example.demo.salescontrol.infrastructure;

import com.example.demo.salescontrol.model.entities.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Product findOneByIdAndDeletedIsFalse(Integer productId);

    List<Product> findAllByDeletedIsFalse();
}