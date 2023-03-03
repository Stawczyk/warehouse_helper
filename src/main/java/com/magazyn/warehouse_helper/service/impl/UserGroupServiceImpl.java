package com.magazyn.warehouse_helper.service.impl;


import com.magazyn.warehouse_helper.Exception.ResourceNotFoundException;
import com.magazyn.warehouse_helper.model.Product;
import com.magazyn.warehouse_helper.model.Transactions;
import com.magazyn.warehouse_helper.model.UserGroup;
import com.magazyn.warehouse_helper.repository.ProductRepository;
import com.magazyn.warehouse_helper.repository.TransactionsRepository;
import com.magazyn.warehouse_helper.repository.UserGroupRepository;
import com.magazyn.warehouse_helper.service.TransactionsService;
import com.magazyn.warehouse_helper.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class UserGroupServiceImpl implements UserGroupService {

    private TransactionsService transactionsService;
    private ProductRepository productRepository;
    private UserGroupRepository userGroupRepository ;
    private TransactionsRepository transactionsRepository;

@Autowired
    public UserGroupServiceImpl(TransactionsService transactionsService, ProductRepository productRepository, UserGroupRepository userGroupRepository, TransactionsRepository transactionsRepository) {
        this.transactionsService = transactionsService;
        this.productRepository = productRepository;
        this.userGroupRepository = userGroupRepository;
        this.transactionsRepository = transactionsRepository;
    }

    // zapisywanie UserGroup
    @Override
    public UserGroup saveUserGroup(UserGroup userGroup) {

        return userGroupRepository.save(userGroup);
    }

    // lista wszystkich  UserGroup

    @Override
    public List<UserGroup> getAllUserGroup() {
        return  userGroupRepository.findAll();
    }
    // szukanie UserGroup po ID

    @Override
    public UserGroup getUserGroupByID(Long id) {
        return  userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));
    }
    // aktualizacja UserGroup

    @Override
    public UserGroup updateUserGroup(UserGroup userGroup, Long id) {

        UserGroup existingUserGroup = userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));

        existingUserGroup.setName(userGroup.getName());
        existingUserGroup.setProductsMaps(userGroup.getProductsMaps());
        userGroupRepository.save(existingUserGroup);

        return existingUserGroup;
    }

    // kaswoanie UserGroup

    @Override
    public void deleteUserGroup(Long id) {

        userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));

        userGroupRepository.deleteById(id);

    }
    // wyciaganie wszsytkich produktów należacych do daneggo UserGroup
    @Override
    public Set<Product> getAllProduct(Long id) {
        UserGroup existingUserGroup =   userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));
      Map<Product, Integer> mapaProduktów = existingUserGroup.getProductsMaps();
      Set<Product>setProduct= mapaProduktów.keySet();
    return  setProduct;

}

    @Override
    public List<Transactions> getAllTransactions(Long id) {
        userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));
      List<Transactions> allTransactions =  transactionsRepository.findAll().stream().filter((transactions)->transactions.getUserGroupId()==id).collect(Collectors.toList());

        return allTransactions;
    }

    // tranzakcje SELL
    @Override
    public void sellProducts(Long idUserGroup, Map<Product, Integer> thingsToBeBought, String nameBuyer,Long idUser,String note,double price) {

      UserGroup existingUserGroup =  userGroupRepository.findById(idUserGroup).orElseThrow(()->new ResourceNotFoundException("User Group","id",idUserGroup));

        Map<Product, Integer> mapInMagazin = existingUserGroup.getProductsMaps();
        for (Product productTooBought : thingsToBeBought.keySet()) {
            for (Product productInBase : mapInMagazin.keySet()) {

                if (productInBase == productTooBought) {
                    if (mapInMagazin.get(productInBase) - thingsToBeBought.get(productTooBought) < 0) {
                        throw new RuntimeException("not");
                    } else {
                        Integer x = mapInMagazin.get(productInBase) - thingsToBeBought.get(productTooBought);
                        mapInMagazin.put(productInBase, x);

                    }
                }
            }

        }
       existingUserGroup.setProductsMaps(mapInMagazin);
        userGroupRepository.save(existingUserGroup);
        Transactions transactions = new Transactions(thingsToBeBought,nameBuyer,idUser,idUserGroup,note,price) ;
        transactionsService.saveTransaction(transactions);
    }



}