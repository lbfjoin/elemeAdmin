package com.company.view;

import com.company.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void updateBusiness();
    public void removeBusiness();
    //添加一个商家登陆验证的方法
    public Business login();
    //添加查询特定商家信息方法
    public void selectBusinessId(Business business);
    public void showBusinessInfo(Integer businessId);
    //修改商家信息
    public void updateBusinessInfo(Integer businessId);
    public void updateBusinessPassword(Integer businessId);

}
