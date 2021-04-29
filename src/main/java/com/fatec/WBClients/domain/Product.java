package com.fatec.WBClients.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduct;
    private String nameProduct;


    public Product(Product product) {
        this.idProduct = product.getIdProduct();
        this.nameProduct = product.getNameProduct();
    }
}
