package com.magazyn.warehouse_helper.repository;

import com.magazyn.warehouse_helper.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroup,Long> {
}
