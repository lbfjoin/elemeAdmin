package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface BusinessDao {
    //显示所有商家列表   可选输入商家businessName和businessAddress
    public List<Business> listBusiness(String businessName, String businessAddress);
    public int saveBusiness(String businessName);
    public void updateBusiness(String businessName);
    public void removeBusiness(String businessName);
}
