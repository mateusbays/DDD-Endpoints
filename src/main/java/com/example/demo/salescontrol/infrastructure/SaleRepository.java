package com.example.demo.salescontrol.infrastructure;

import com.example.demo.salescontrol.model.entities.Sale;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<Sale, Integer> {

    Sale findOneById(Integer saleId);

    Iterable<Sale> findAll();
}