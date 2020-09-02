package sell.view.Impl;

import sell.dao.Impl.FoodDaoImpl;
import sell.domain.Food;
import sell.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/14 21:03
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
        FoodDaoImpl dao = new FoodDaoImpl();
        dao.listFood(businessId);

    }

    @Override
    public void saveFood(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        Food food = new Food();
        System.out.println("请输入食物名称");
        food.setFoodName(input.next());
        System.out.println("请输入食物价格");
        food.setFoodPrice(input.nextDouble());
        System.out.println("请输入商家编号");
        food.setBusinessId(input.nextInt());
        dao.saveFood(food);
    }

    @Override
    public void removeFood(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        Food food = new Food();
        System.out.println("请输入想要删除的食物编号");
        food.setFoodId(input.nextInt());
        dao.removeFood(food.getBusinessId());

    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        Food food = new Food();
        System.out.println("请输入想要修改的食物编号");

    }
}
