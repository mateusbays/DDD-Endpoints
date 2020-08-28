package com.example.demo.salescontrol.actions.controllers;

import com.example.demo.salescontrol.model.entities.Product;
import com.example.demo.salescontrol.model.service.ProductServiceImpl;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/v1/products")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/v1/products/{doctype}")
    public void returnArchive(@PathVariable String doctype) throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        productService.returnArchive(doctype);
    }

    @PostMapping("/v1/products")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/v1/products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Integer id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/v1/products/{id}")
    public Product deleteProduct(@PathVariable("id") Integer id) {
        return productService.deleteProduct(id);
    }


}
