package sell.dao;



import sell.domain.Business;

import java.util.List;

public interface BusinessDao {
    //显示商家列表 ， 并对商家列表进行增删改查操作
    public List<Business> listBusiness(String businessName, String businessAddress);
    public void saveBusiness(Business business);
    public void updateBusiness(Business business);
    public void removeBusiness(Business business);
}
