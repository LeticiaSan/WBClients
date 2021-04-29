package com.fatec.WBClients.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sales;
    private long id_product;
    private long id;


    public Sales(Sales sales) {
        this.id_sales = sales.getId_sales();
        this.id_product = sales.getId_product();
        this.id = sales.getId();
    }
}
