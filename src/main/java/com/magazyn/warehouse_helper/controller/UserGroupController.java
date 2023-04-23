package com.magazyn.warehouse_helper.controller;

import com.magazyn.warehouse_helper.model.Product;
import com.magazyn.warehouse_helper.model.UserGroup;
import com.magazyn.warehouse_helper.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/userGroup")
public class UserGroupController {
    private UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    // REST API saveUserGroup
    @PostMapping
    public ResponseEntity<UserGroup> saveUserGroup(@RequestBody UserGroup userGroup){
        return new ResponseEntity<UserGroup>(userGroupService.saveUserGroup(userGroup), HttpStatus.CREATED);
    }
    // REST API getAllUserGroup
    @GetMapping
    public List<UserGroup> getAllUserGroup(){
     return userGroupService.getAllUserGroup();
    }
    // REST API getUserGroupByID
    @GetMapping("{id}")
    public ResponseEntity<UserGroup> getUserGroupByID(@PathVariable("id") Long id ){
        return new ResponseEntity<UserGroup>(userGroupService.getUserGroupByID(id),HttpStatus.OK);
    }
    // REST API updateUserGroup
    @PutMapping ("{id}")
    public ResponseEntity<UserGroup> updateUserGroup(@PathVariable ("id") Long id , @RequestBody UserGroup userGroup){
        return new ResponseEntity<UserGroup>(userGroupService.updateUserGroup(userGroup,id),HttpStatus.OK);
    }
    //REST API deleteUserGroup
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteUserGroup(@PathVariable("id") Long id ){
        userGroupService.deleteUserGroup(id);
        return new ResponseEntity<String>("UserGroup is delete",HttpStatus.OK);
    }

    // REST API allProductByUserId

    @GetMapping ("{id}")
    public Set<Product> allProductByUserId(@PathVariable("id") Long id){

        return userGroupService.getAllProduct(id);
    }

    // REST API sellTransaction
    @PostMapping("{idUserGroup}|{nameBuyer}|{idUser}|{note}")
    public ResponseEntity<String> sellTransaction(@PathVariable("id") long idUserGroup,
                                                  @RequestBody  Map<Product, Integer> thingsToBeSell,
                                                  @PathVariable("nameBuyer") String nameBuyer,
                                                  @PathVariable ("idUser")Long idUser,
                                                  @PathVariable ("note") String note){
        userGroupService.sellProducts(idUserGroup,thingsToBeSell,nameBuyer,idUser,note);
        return new ResponseEntity<String>("sellTransaction i redy to aprov ",HttpStatus.CREATED);
    }


}
