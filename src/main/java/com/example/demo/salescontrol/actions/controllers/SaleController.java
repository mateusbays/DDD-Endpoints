package com.example.demo.salescontrol.actions.controllers;

import com.example.demo.salescontrol.model.entities.Sale;
import com.example.demo.salescontrol.model.service.SaleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @GetMapping("/v1/sales")
    public @ResponseBody Iterable<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/v1/sales/{id}")
    public @ResponseBody Sale getOneSale(@PathVariable Integer id){return saleService.getOneSale(id);}

    @PostMapping("/v1/sales")
    public Sale insertSale(@RequestBody Sale sale) {
        return saleService.insertSale(sale);
    }


    }



