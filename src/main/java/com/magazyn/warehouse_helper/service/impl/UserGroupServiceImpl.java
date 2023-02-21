package com.example.EnglishShopMainApp.service.impl;


import com.magazyn.warehouse_helper.Exception.ResourceNotFoundException;
import com.magazyn.warehouse_helper.model.UserGroup;
import com.magazyn.warehouse_helper.repository.UserGroupRepository;
import com.magazyn.warehouse_helper.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserGroupServiceImpl implements UserGroupService {

  private UserGroupRepository userGroupRepository ;

    public UserGroupServiceImpl(UserGroupRepository userGroupRepository) {
        super();
        this.userGroupRepository = userGroupRepository;
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
        existingUserGroup.setProductsList(userGroup.getProductsList());
        userGroupRepository.save(existingUserGroup);

        return existingUserGroup;
    }

    // kaswoanie UserGroup

    @Override
    public void deleteUserGroup(Long id) {

        userGroupRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User Group","id",id));

        userGroupRepository.deleteById(id);

    }


}
