package sell.view;


import sell.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void removeBusiness();

    //添加一个商家登陆验证的方法
    public Business login();
    //查询商家信息
    public void showBusinessInfo(Integer businessId);
    //修改商家信息
    public void updateBusinessInfo(Integer businessId);
    public void updateBusinessPassword(Integer businessId);
}
