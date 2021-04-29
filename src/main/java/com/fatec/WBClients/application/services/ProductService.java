/*
package com.fatec.WBClients.application.services;

import com.fatec.WBClients.application.repositories.ProductRepository;
import com.fatec.WBClients.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listAll() {
        return repository.findAll()
                .stream()
                .map(Product::new)
                .collect(Collectors.toList());
    }


    public Product findById(Long id) {
        return repository.findById(id).get();
    }

    public Product findByName(String name_product) {
        return repository.findByName(name_product).get();
    }

    public void save(Product Product) {
        repository.save(Product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}*/