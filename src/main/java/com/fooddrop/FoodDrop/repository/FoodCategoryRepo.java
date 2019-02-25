package com.fooddrop.FoodDrop.repository;

import com.fooddrop.FoodDrop.model.FoodCategory;
import org.springframework.data.repository.CrudRepository;

public interface FoodCategoryRepo extends CrudRepository<FoodCategory, Long> {
}
