package sell.dao;



import sell.domain.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> listFood(Integer businessId   );
    public void  saveFood(Food food);
    public void  removeFood(Integer foodId);
    public void  updateFood(Food food);

}
