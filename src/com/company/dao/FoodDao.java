package com.company.dao;

import com.company.domain.Business;
import com.company.domain.Food;

import java.util.List;

public interface FoodDao {
    //显示所有食物列表   可选输入商家businessName和businessAddress
    public List<Food> listFood(Integer businessId   );
    public void  saveFood(Food food);
    public void  removeFood(Integer foodId);
    public void  updateFood(Food food);
    public Food getFoodById(Integer foodId);
}
