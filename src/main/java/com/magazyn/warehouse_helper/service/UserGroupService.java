package com.magazyn.warehouse_helper.service;


import com.magazyn.warehouse_helper.model.UserGroup;

import java.util.List;

public interface UserGroupService {

    UserGroup saveUserGroup (UserGroup userGroup);

    List<UserGroup> getAllUserGroup();


    UserGroup getUserGroupByID(Long id);

    UserGroup updateUserGroup(UserGroup userGroup, Long id);

    void deleteUserGroup(Long id );
}
