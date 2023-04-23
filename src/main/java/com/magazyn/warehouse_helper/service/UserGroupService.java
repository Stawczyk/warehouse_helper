package com.magazyn.warehouse_helper.service;


import com.magazyn.warehouse_helper.model.Product;
import com.magazyn.warehouse_helper.model.Transactions;
import com.magazyn.warehouse_helper.model.UserGroup;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserGroupService {

    UserGroup saveUserGroup (UserGroup userGroup);

    List<UserGroup> getAllUserGroup();


    UserGroup getUserGroupByID(Long id);

    UserGroup updateUserGroup(UserGroup userGroup, Long id);

    void deleteUserGroup(Long id );

    Set<Product> getAllProduct(Long id);

    List<Transactions> getAllTransactions (Long id);

    void sellProducts (Long idUserGroup, Map<Product, Integer> thingsToBeSell, String nameBuyer,Long idUser,String note);

}
