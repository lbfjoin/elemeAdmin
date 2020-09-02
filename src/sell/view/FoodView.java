package sell.view;

public interface FoodView {
    public void listFoodAll(Integer businessId);
    public void listFoodBySearch(Integer businessId);
    public void saveFood(Integer businessId);
    public void removeFood(Integer businessId);
    public void updateFood(Integer businessId);
}
