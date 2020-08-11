package com.company.view.Impl;

import com.company.dao.BusinessDao;
import com.company.dao.Impl.BusinessDaoImpl;
import com.company.domain.Business;
import com.company.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/7 15:18
 */
public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }

    }

    /**
     * 搜索
     */
    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否需要输入商家名称关键字(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键字：");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键字：");
            businessAddress = input.next();
        }
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    /**
     * 保存商家
     */
    @Override
    public void saveBusiness() {
        System.out.println("请输入商家名字");
        String businessName = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        if (businessId > 0) {
            System.out.println("新建商家成功！ 商家编号" + businessId);

        } else {
            System.out.println("新建商家失败！");
        }
    }

    @Override
    public void updateBusiness() {
        System.out.println("请输入商家名字");
        String businessName = input.next();
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.updateBusiness(businessName, businessId);
    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入商家名字");
        String businessName = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.removeBusiness(businessName);
        System.out.println("删除商家成功");

    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();
        System.out.println("请输入密码");
        String password = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.getBusinewwByNameByPassword(businessId, password);
    }

    @Override
    public void selectBusinessId(Business business) {
        Integer businessId = business.getBusinessId();
//        business.getPassword();
//        business.getBusinessName();
//        business.getBusinessAddress();
//        business.getBusinessExplain();
//        business.getStarPrice();
//        business.getDeliveryPrice();
        System.out.println("dkfsdkjsfsd");
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.selectBusiness(businessId);

    }

    @Override
    public void showBusinessInfo(Integer businessId) {
        //调用dao
        BusinessDaoImpl dao = new BusinessDaoImpl();
        Business business = dao.getBusinessByBusinessId(businessId);
        System.out.println(business);
    }

    @Override
    public void updateBusinessInfo(Integer businessId) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        Business business = dao.getBusinessByBusinessId(businessId);
        //显示一边商家信息，方便用户查看修改
        String inputStr = "";
        System.out.println(business);
        System.out.println("是否修改商家名称y/n");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的商家名称");
            business.setBusinessName(input.next());
        }
        System.out.println("是否需要修改商家地址y/n");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的商家地址");
            business.setBusinessAddress(input.next());
        }
        System.out.println("是否需要修改商家介绍y/n");
        inputStr = input.next();

        if (inputStr.equals("y")){
            System.out.println("请输入新的商家介绍");
            business.setBusinessExplain(input.next());
        }
        System.out.println("是否需要修改商家起送费y/n");
        inputStr = input.next();

        if (inputStr.equals("y")){
            System.out.println("请输入新的商家起送费");
            business.setStarPrice(input.nextDouble());
        }
        System.out.println("是否需要修改商家配送费y/n");
        inputStr = input.next();

        if (inputStr.equals("y")){
            System.out.println("请输入新的商家配送费");
            business.setDeliveryPrice(input.nextDouble());
        }

        dao.updateBusinessByBusinessId(business);



    }

    @Override
    public void updateBusinessPassword(Integer businessId) {
        Business business = new Business();
        String inputStr = "";
        System.out.println("是否要更改密码y/n");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入新的密码");
            business.setPassword(input.next());
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.updateBusinessPassword(businessId,business.getPassword());
    }


}

