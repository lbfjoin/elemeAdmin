package sell.view.Impl;

import sell.dao.Impl.BusinessDaoImpl;
import sell.domain.Business;
import sell.view.BusinessView;

import java.util.List;
import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/14 19:28
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

    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否输入商家名称关键字y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键字");
            businessName = input.next();
        }
        System.out.println("是否输入商家地址关键字y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键字");
            businessAddress = input.next();
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());

        }
    }

    @Override
    public void saveBusiness() {
        System.out.println("请输入商家名字");
        String businessName = input.next();
        Business business = new Business();
        business.setBusinessName(businessName);
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.saveBusiness(business);

    }

    @Override
    public void removeBusiness() {
        System.out.println("请输入商家编号");
        int businessId = input.nextInt();
        Business business = new Business();
        business.setBusinessId(businessId);
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.removeBusiness(business);

    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号");
        Integer businessId = input.nextInt();
        System.out.println("请输入商家密码");
        String password = input.next();
        BusinessDaoImpl dao = new BusinessDaoImpl();
        return dao.getBusinewwByNameByPassword(businessId, password);
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
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家名称");
            business.setBusinessName(input.next());
        }
        System.out.println("是否需要修改商家地址y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家地址");
            business.setBusinessAddress(input.next());
        }
        System.out.println("是否需要修改商家介绍y/n");
        inputStr = input.next();

        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家介绍");
            business.setBusinessExplain(input.next());
        }
        System.out.println("是否需要修改商家起送费y/n");
        inputStr = input.next();

        if (inputStr.equals("y")) {
            System.out.println("请输入新的商家起送费");
            business.setStarPrice(input.nextDouble());
        }
        System.out.println("是否需要修改商家配送费y/n");
        inputStr = input.next();

        if (inputStr.equals("y")) {
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
        if (inputStr.equals("y")) {
            System.out.println("请输入新的密码");
            business.setPassword(input.next());
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        dao.updateBusinessPassword(businessId, business.getPassword());

    }
}
