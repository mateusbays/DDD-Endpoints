package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.model.entities.Product;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Iterable<Product> getAllProducts();

    Product insertProduct(Product product);

    Product updateProduct(Product product, Integer id);

    Product deleteProduct(Integer id);
    
	void returnArchive(String doctype) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

}
