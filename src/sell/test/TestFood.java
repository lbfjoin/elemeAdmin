package sell.test;

import sell.dao.Impl.FoodDaoImpl;
import sell.domain.Food;


import java.util.List;

/**
 * @author lbf
 * @date 2020/8/14 21:17
 */
public class TestFood {
    public static void main(String[] args) {
        FoodDaoImpl dao = new FoodDaoImpl();
        Food food = new Food();
//        food.setBusinessId(10001);
//        List<Food> list = dao.listFood(food.getBusinessId());
//        for (Food f:list){
//            System.out.println(f.getFoodId() + f.getFoodName() + f.getFoodExplain() + f.getFoodPrice() + f.getBusinessId());
//        }
//        food.setFoodName("汉堡");
//        food.setFoodPrice(22.0);
//        food.setBusinessId(10002);
//        dao.saveFood(food);
//        food.setFoodName("hhh");
//        food.setFoodExplain("ddd");
//        food.setFoodPrice(33.0);
//        food.setFoodId(8);
//        dao.updateFood(food);
        food.setFoodId(8);
        dao.removeFood(food.getFoodId());
    }
}
