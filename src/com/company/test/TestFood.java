package com.company.test;

import com.company.dao.Impl.FoodDaoImpl;
import com.company.domain.Food;
import com.company.view.Impl.FoodViewImpl;

import java.util.List;

/**
 * @author lbf
 * @date 2020/8/8 15:54
 */
public class TestFood {
    public static void main(String[] args) {
        FoodDaoImpl dao = new FoodDaoImpl();
        FoodViewImpl view = new FoodViewImpl();


//        dao.listFood("饺子", null);
    }
}
