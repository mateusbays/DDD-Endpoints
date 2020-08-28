package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.infrastructure.ProductRepository;
import com.example.demo.salescontrol.infrastructure.SaleRepository;
import com.example.demo.salescontrol.model.entities.Product;
import com.example.demo.salescontrol.model.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getOneSale(Integer id) {
        return saleRepository.findOneById(id);
    }

    @Override
    public Sale insertSale(Sale sale) {
        Sale saleSave = new Sale();
        saleSave.setPersonSeller(sale.getPersonSeller());
        saleSave.setProductId(sale.getProductId());
        saleSave.setQuantity(sale.getQuantity());

        Product product = productRepository.findOneByIdAndDeletedIsFalse(sale.getProductId());

        productRepository.save(product);
        return saleRepository.save(saleSave);
    }

}