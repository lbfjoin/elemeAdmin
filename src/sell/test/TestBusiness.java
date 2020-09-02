package sell.test;

import sell.dao.BusinessDao;
import sell.dao.Impl.BusinessDaoImpl;
import sell.domain.Business;

import java.util.List;

/**
 * @author lbf
 * @date 2020/8/12 20:58
 */
public class TestBusiness {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness("饺子", "浑南区");
       for (Business business:list){
           System.out.println(business.getBusinessId() + "\t" + business.getBusinessName() +"\t" +  business.getBusinessAddress() + "\t" + business.getBusinessExplain()
           + "\t" + business.getStarPrice() + "\t" + business.getDeliveryPrice());
       }
        Business business = new Business();
//       business.setBusinessName("heiheihei");
//        dao.saveBusiness(business);
//        business.setBusinessId(10010);
//        business.setBusinessExplain("hhhh");
//        dao.updateBusiness(business);
        business.setBusinessId(10010);
        dao.removeBusiness(business);
    }
}
