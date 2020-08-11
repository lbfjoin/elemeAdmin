package com.company.view.Impl;

import com.company.dao.FoodDao;
import com.company.dao.Impl.FoodDaoImpl;

import com.company.domain.Food;
import com.company.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/8 10:14
 */
public class FoodViewImpl implements FoodView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listFoodAll(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        List<Food> list = dao.listFood(businessId);
        System.out.println("食物编号\t食物名字\t食物介绍\t食物价格\t商家编号");
        for (Food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" + f.getFoodExplain() + "\t" + f.getFoodPrice() + "\t" +
                    f.getBusinessId());
        }
    }

    @Override
    public void listFoodBySearch(Integer businessId) {
        String foodName = "";
        String foodExplain = "";
        String inputStr = "";
        System.out.println("是否需要输入食物关键字y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入食物关键字");
            foodName = input.next();
        }
        System.out.println("是否需要输入食物介绍y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入食物介绍关键字");
            foodExplain = input.next();
        }
        FoodDaoImpl dao = new FoodDaoImpl();
        List<Food> list = dao.listFood(businessId);
        System.out.println("食物编号\t食物名字\t食物介绍\t食物价格\t商家编号\t");
        for (Food f : list) {
            System.out.println(f.getFoodId() + "\t" + f.getFoodName() + "\t" + f.getFoodExplain() + "\t" + f.getFoodPrice() + "\t" + f.getBusinessId());
        }

    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入食物名称");
        food.setFoodName(input.next());
        System.out.println("请输入食物价格");
        food.setFoodPrice(input.nextDouble());
        System.out.println("请输入商家编号");
        food.setBusinessId(input.nextInt());
        FoodDaoImpl dao = new FoodDaoImpl();
        dao.saveFood(food);
//        dao.saveFood();
        System.out.println("新建食物成功");

    }

    @Override
    public void removeFood(Integer businessId) {

        FoodDaoImpl dao = new FoodDaoImpl();
        System.out.println("请输入想要删除食物的编号");
        int foodId = input.nextInt();
        dao.removeFood(foodId);
//        dao.removeFood();
        System.out.println("删除成功");
    }

    @Override
    public void updateFood(Integer businessId) {

        FoodDao dao = new FoodDaoImpl();
//        List<Food> list = showFoodList(businessId);
        List<Food> list = dao.listFood(businessId);
        if (list.size() == 0) {
            System.out.println("没有任何食品！");
        } else {
            System.out.println("请选择要更新的食品编号：");
            int foodId = input.nextInt();
            Food food = dao.getFoodById(foodId);
            System.out.println(food);

            String inputStr = "";
            System.out.println("是否更新食品名称(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品名称：");
                food.setFoodName(input.next());
            }

            System.out.println("是否更新食品介绍(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品介绍：");
                food.setFoodExplain(input.next());
            }

            System.out.println("是否更新食品价格(y/n)：");
            inputStr = input.next();
            if (inputStr.equals("y")) {
                System.out.println("请输入新的食品价格：");
                food.setFoodPrice(input.nextDouble());
            }


        }
    }
}
