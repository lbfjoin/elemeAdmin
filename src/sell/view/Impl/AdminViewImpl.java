package sell.view.Impl;

import sell.dao.Impl.AdminDaoImpl;
import sell.doamain.Admin1;
import sell.view.AdminView1;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/9 19:23
 */
public class AdminViewImpl implements AdminView1 {
Scanner input =new Scanner(System.in);
    @Override
    public Admin1 login() {
        System.out.println("请输入管理员账号");
        String adminName = input.next();
        System.out.println("请输入管理员密码");
        String password = input.next();
        AdminDaoImpl dao = new AdminDaoImpl();
        return dao.getAdminNamePassword(adminName, password);
    }
}
