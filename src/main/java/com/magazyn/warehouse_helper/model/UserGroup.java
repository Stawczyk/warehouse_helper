package com.magazyn.warehouse_helper.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="UserGroup")
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="ProductsMaps")

    Map<Product,Integer> productsMaps;

    public UserGroup(){}

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

    public Map<Product,Integer> getProductsMaps() {
        return productsMaps;
    }

    public void setProductsMaps(Map<Product,Integer> productsMaps) {
        this.productsMaps = productsMaps;
    }

    public UserGroup(long id, String name, Map<Product, Integer> productsMaps) {
        this.id = id;
        this.name = name;
        this.productsMaps = productsMaps;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ProductsList=" + productsMaps +
                '}';
    }
}
