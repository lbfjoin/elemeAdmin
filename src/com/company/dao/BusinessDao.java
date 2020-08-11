package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface BusinessDao {
    //显示所有商家列表   可选输入商家businessName和businessAddress
    public List<Business> listBusiness(String businessName, String businessAddress);
    public int saveBusiness(String businessName);
    public void updateBusiness(String businessName,Integer businessID);
    public void removeBusiness(String businessName);
    public Business getBusinewwByNameByPassword(Integer businessId,String password);

    //查询商家信息
    public void selectBusiness(Integer businessId);
    public Business getBusinessByBusinessId(Integer businessId);
    //修改商家信息
    public void updateBusinessByBusinessId(Business business);
    //更改密码
    public void updateBusinessPassword(Integer businessId,String password);
}
