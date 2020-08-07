package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface FoodDao {
    //显示所有食物列表   可选输入商家businessName和businessAddress
    public List<Business> listBusiness(String foodName, String foodExplain);
}
