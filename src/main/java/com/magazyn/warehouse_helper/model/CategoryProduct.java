package com.magazyn.warehouse_helper.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Category")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name="vat", nullable=false)
    private Double vat;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
 public CategoryProduct(){}

    public CategoryProduct(String name, Double vat) {
        this.name = name;
        this.vat = vat;
    }
}
