package com.company.test;

import com.company.dao.Impl.BusinessDaoImpl;
import com.company.view.Impl.BusinessViewImpl;

/**
 * @author lbf
 * @date 2020/8/7 15:01
 */
public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
//        dao.listBusiness(null,"沈阳");
//        dao.listBusiness("饺子","沈阳");
//        dao.listBusiness("饺子",null);
        BusinessViewImpl view = new BusinessViewImpl();
        view.listBusinessAll();
//        dao.listBusiness(null,null);
        dao.listBusiness("米饭",null);


    }
}
