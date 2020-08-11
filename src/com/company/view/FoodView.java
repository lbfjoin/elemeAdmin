package com.company.view;

import com.company.domain.Business;
import com.company.domain.Food;

import java.util.List;

public interface FoodView {
    public void listFoodAll(Integer businessId);
    public void listFoodBySearch(Integer businessId);
    public void saveFood(Integer businessId);
    public void removeFood(Integer businessId);
    public void updateFood(Integer businessId);


}
