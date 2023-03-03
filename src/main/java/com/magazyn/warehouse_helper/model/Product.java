package com.magazyn.warehouse_helper.model;


import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name="Product")
public class Product {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column(name="nameProduct", nullable=false)
    private String nameProduct;
    @Column(name="serialNumber", nullable=false)
    private String serialNumber;
    @Column(name="priceNet")
    private Double priceNet;
    @Column(name="priceGross")
    private Double priceGross;
    @Column(name="assumedQuantity")
    private int assumedQuantity;
    @Column(name="expirationDate")
    private String expirationDate;
    @Column(name="CategoryProduct", nullable=false)
    private CategoryProduct categoryProduct;
    @Column(name="producer")
    private String producer;
    @Lob
    private byte [] photo;
    @Column(name="note")
    private String note;
    @Column(name="emptyField1")
    private String emptyField1;
    @Column(name="emptyField2")
    private String emptyField2;
    @Column(name="emptyField3")
    private String emptyField3;

    public Product(){}

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getPriceNet() {
        return priceNet;
    }

    public void setPriceNet(Double priceNet) {
        this.priceNet = priceNet;
    }

    public Double getPriceGross() {
        return priceGross;
    }

    public void setPriceGross(Double priceGross) {
        this.priceGross = priceGross;
    }

    public int getAssumedQuantity() {
        return assumedQuantity;
    }

    public void setAssumedQuantity(int assumedQuantity) {
        this.assumedQuantity = assumedQuantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmptyField1() {
        return emptyField1;
    }

    public void setEmptyField1(String emptyField1) {
        this.emptyField1 = emptyField1;
    }

    public String getEmptyField2() {
        return emptyField2;
    }

    public void setEmptyField2(String emptyField2) {
        this.emptyField2 = emptyField2;
    }

    public String getEmptyField3() {
        return emptyField3;
    }

    public void setEmptyField3(String emptyField3) {
        this.emptyField3 = emptyField3;
    }

    public Product(String nameProduct, String serialNumber, Double priceNet, Double priceGross, int assumedQuantity, String expirationDate, String producer, CategoryProduct categoryProduct, byte[] photo, String note, String emptyField1, String emptyField2, String emptyField3) {
        this.nameProduct = nameProduct;
        this.serialNumber = serialNumber;
        this.priceNet = priceNet;
        this.priceGross = priceGross;
        this.assumedQuantity = assumedQuantity;
        this.expirationDate = expirationDate;
        this.producer = producer;
        this.photo = photo;
        this.note = note;
        this.emptyField1 = emptyField1;
        this.emptyField2 = emptyField2;
        this.emptyField3 = emptyField3;
        this.categoryProduct= categoryProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", priceNet=" + priceNet +
                ", priceGross=" + priceGross +
                ", assumedQuantity=" + assumedQuantity +
                ", expirationDate='" + expirationDate + '\'' +
                ", category='" + categoryProduct + '\'' +
                ", producer='" + producer + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", note='" + note + '\'' +
                ", emptyField1='" + emptyField1 + '\'' +
                ", emptyField2='" + emptyField2 + '\'' +
                ", emptyField3='" + emptyField3 + '\'' +
                '}';
    }
}
