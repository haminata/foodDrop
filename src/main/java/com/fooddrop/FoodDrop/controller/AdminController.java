package com.fooddrop.FoodDrop.controller;

import com.fooddrop.FoodDrop.model.Admin;
import com.fooddrop.FoodDrop.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminRepo adminRepo;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewAdmin(@RequestBody Admin adminDetails){

        adminRepo.save(adminDetails);
        return "saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Admin> getAllAdmin(){
        return adminRepo.findAll();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id,
                                             @RequestBody Admin adminDetails){
        return adminRepo.findById(id)
                .map(oldAdminDetails ->{
                    oldAdminDetails.setFirstName(adminDetails.getFirstName());
                    oldAdminDetails.setLastName(adminDetails.getLastName());
                    oldAdminDetails.setAddress(adminDetails.getAddress());
                    oldAdminDetails.setEmail(adminDetails.getEmail());
                    oldAdminDetails.setPassword(adminDetails.getPassword());
                    oldAdminDetails.setPostCode(adminDetails.getPostCode());
                    oldAdminDetails.setRole(adminDetails.getRole());

                    Admin updatedAdmin = adminRepo.save(oldAdminDetails);
                    return ResponseEntity.ok().body(updatedAdmin);
                }).orElse(ResponseEntity.notFound().build());
    }

//    @DeleteMapping(path = "/delete/{id}")
//    public ResponseEntity<?> deleteAdminById(PathVariable Long id){
//        return adminRepo.findById(id)
//                .map(adminRecord ->{
//                    adminRepo.findById(id);
//                    return ResponseEntity.ok().build();
//
//                    )}.orElse(ResponseEntity.notFound().build());
//
//
//    }
}
