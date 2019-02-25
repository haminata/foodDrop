package com.fooddrop.FoodDrop.controller;

import com.fooddrop.FoodDrop.model.FoodCategory;
import com.fooddrop.FoodDrop.repository.FoodCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/category")
public class FoodCategoryController {
    @Autowired
    private FoodCategoryRepo foodCategoryRepo;

    @PostMapping("/add")
    public @ResponseBody String addNewFoodCategory(@RequestBody FoodCategory foodDeatils){
        foodCategoryRepo.save(foodDeatils);
        return "Food category saved";

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<FoodCategory> getAllCustomers(){

        return foodCategoryRepo.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FoodCategory> updateCustomer(@PathVariable Long id,
                                                       @RequestBody FoodCategory foodDeatils){
        return foodCategoryRepo.findById(id)
                .map(oldCategory ->{
                    oldCategory.setName(foodDeatils.getName());
                    oldCategory.setDescription(foodDeatils.getDescription());

                    FoodCategory updatedCustomer = foodCategoryRepo.save(oldCategory);
                    return ResponseEntity.ok().body(updatedCustomer);
                }).orElse(ResponseEntity.notFound().build());

    }
}
