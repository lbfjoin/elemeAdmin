package sell.dao;



import sell.domain.Business;

import java.util.List;

public interface BusinessDao {
    //显示商家列表 ， 并对商家列表进行增删改查操作
    public List<Business> listBusiness(String businessName, String businessAddress);
    public void saveBusiness(Business business);
    public void updateBusiness(Business business);
    public void removeBusiness(Business business);
    //商家登陆时查看信息
    public Business getBusinewwByNameByPassword(Integer businessId, String password);
    //查询商家信息
    public Business getBusinessByBusinessId(Integer businessId);
    //修改商家信息
    public void updateBusinessByBusinessId(Business business);
    //更改密码
    public void updateBusinessPassword(Integer businessId,String password);

}
