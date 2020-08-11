package sell.test;

import sell.dao.BusinessDao;
import sell.dao.Impl.BusinessDaoImpl;
import sell.doamain.Business1;

import java.util.List;

/**
 * @author lbf
 * @date 2020/8/9 19:15
 */
public class BusinessTest {
    public static void main(String[] args) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business1> list = dao.listBusiness(null, null);

        }
    }

