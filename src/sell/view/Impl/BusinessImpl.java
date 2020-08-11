package sell.view.Impl;




import com.company.domain.Business;
import sell.dao.BusinessDao;
import sell.dao.Impl.BusinessDaoImpl;
import sell.doamain.Business1;
import sell.view.BusinessView1;

import java.util.List;
import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/9 19:23
 */
public class BusinessImpl implements BusinessView1 {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business1> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business1 b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    @Override
    public void listBusinessBySearch() {
      String businessName = "";
      String businessAddress = "";
      String inputStr = "";
        System.out.println("是否需要输入商家名称关键字(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入名称关键字");
             businessName = input.next();
        } System.out.println("是否需要输入商家地址关键字(y/n):");
        inputStr = input.next();
        if (inputStr.equals("y")){
            System.out.println("请输入商家地址关键字：");
            businessAddress = input.next();
        } BusinessDao dao = new BusinessDaoImpl();
        List<Business1> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business1 b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t"
                    + b.getBusinessExplain() + "\t" +b.getStarPrice() +"\t" + b.getDeliveryPrice());
        }
    }

    @Override
    public void saveBusiness() {


    }

    @Override
    public void updateBusiness() {

    }

    @Override
    public void removeBusiness() {

    }
}
