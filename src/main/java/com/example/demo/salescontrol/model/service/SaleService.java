package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.model.entities.Sale;
import org.springframework.stereotype.Service;

@Service
public interface SaleService {

    Iterable<Sale> getAllSales();

    Sale getOneSale(Integer id);

    Sale insertSale(Sale sale);

}
