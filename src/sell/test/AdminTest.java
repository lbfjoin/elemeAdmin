package sell.test;

import sell.dao.Impl.AdminDaoImpl;
import sell.doamain.Admin1;

/**
 * @author lbf
 * @date 2020/8/9 16:25
 */
public class AdminTest {
    public static void main(String[] args) {
        AdminDaoImpl dao = new AdminDaoImpl();
        Admin1 admin1 = dao.getAdminNamePassword("zhangsan", "123");
        System.out.println(admin1);
//        System.out.println("============增加信息==============");
//        Admin1 savead = new Admin1(2,"lisi","333");
//        dao.saveAdmin(savead);
//        Admin1 lisi = dao.getAdminNamePassword("lisi", "333");
//        System.out.println(lisi);
//        System.out.println("============修改信息==============");
//        Admin1 updatead = new Admin1(2, "wangwu", "333");
//        dao.updateAdmin(updatead);
//        dao.getAdminNamePassword("wangwu","333");

    }
}
