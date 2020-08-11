package sell.test;


import sell.dao.Impl.AdminDaoImpl;
import sell.domain.Admin;

/**
 * @author lbf
 * @date 2020/8/11 20:54
 */
public class TestAdmin {
    public static void main(String[] args) {
        AdminDaoImpl dao = new AdminDaoImpl();
        Admin admin = dao.getAdminByNameByPass("zhangsan", "123");
        System.out.println(admin);


    }
}
