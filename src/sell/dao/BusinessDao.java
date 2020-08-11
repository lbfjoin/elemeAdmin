package sell.dao;



import com.company.domain.Business;
import sell.doamain.Business1;

import java.util.List;

/**
 * @author lbf
 * @date 2020/8/9 18:53
 */
public interface BusinessDao {
    public List<Business1>  listBusiness(String businessName, String businessAddress);
    public void saveBusiness(String businesseName,String businessAddress);
    public void updateBusiness(String businessName);
    public void removeBusiness(String businessName);


}
