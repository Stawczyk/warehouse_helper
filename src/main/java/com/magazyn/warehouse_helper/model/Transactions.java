package com.magazyn.warehouse_helper.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Transactions")
public class Transactions {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
   @Column(name="ProductsList")
   private Map<Product,Integer> ProductsList;
   @Column(name="nameBuyer")
   private String nameBuyer;
   @Column(name="UserId")

   private Long  UserId;
   @Column(name="idUserGroup")

   private Long  idUserGroup;
   @Column(name="note")

   private String note;
   @Column(name="sum")

   private double sum;

   @CreationTimestamp
   private LocalDateTime createTimeStamp;
   @UpdateTimestamp
   private  LocalDateTime updateTimeStamp;

// status tranzakcji Enum

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Map<Product, Integer> getProductsList() {
      return ProductsList;
   }

   public void setProductsList(Map<Product, Integer> productsList) {
      ProductsList = productsList;
   }

   public String getNameBuyer() {
      return nameBuyer;
   }

   public void setNameBuyer(String nameBuyer) {
      this.nameBuyer = nameBuyer;
   }

   public Long getUserId() {
      return UserId;
   }

   public void setUserId(Long userId) {
      UserId = userId;
   }

   public Long getUserGroupId() {
      return idUserGroup;
   }

   public void setUserGroupId(Long userGroupId) {
      idUserGroup = userGroupId;
   }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

   public double getPrice() {
      return sum;
   }

   public void setPrice(double price) {
      this.sum = price;
   }

   public LocalDateTime getCreateTimeStamp() {
      return createTimeStamp;
   }

   public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
      this.createTimeStamp = createTimeStamp;
   }

   public LocalDateTime getUpdateTimeStamp() {
      return updateTimeStamp;
   }

   public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
      this.updateTimeStamp = updateTimeStamp;
   }

   public Transactions(Map<Product, Integer> productsList, String nameBuyer, Long userId, Long userGroupId, String note, double sum) {
      ProductsList = productsList;
      this.nameBuyer = nameBuyer;
      UserId = userId;
      idUserGroup = userGroupId;
      this.note = note;
      this.sum = sum;
   }

   @Override
   public String toString() {
      return "Transactions{" +
              "id=" + id +
              ", ProductsList=" + ProductsList +
              ", nameBuyer='" + nameBuyer + '\'' +
              ", UserId=" + UserId +
              ", idUserGroup=" + idUserGroup +
              ", note='" + note + '\'' +
              ", price=" + sum +
              ", createTimeStamp=" + createTimeStamp +
              ", updateTimeStamp=" + updateTimeStamp +
              '}';
   }
}
