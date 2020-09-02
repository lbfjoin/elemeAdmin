package sell.view.Impl;

import sell.dao.Impl.AdminDaoImpl;
import sell.domain.Admin;
import sell.view.AdminView;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/14 19:12
 */
public class AdminViewImpl implements AdminView {

    @Override
    public Admin login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入管理员名字");
        String adimnName = scanner.nextLine();
        System.out.println("请输入管理员密码");
        String businessId = scanner.nextLine();
        AdminDaoImpl dao = new AdminDaoImpl();
        return dao.getAdminByNameByPass(adimnName,businessId);
    }
}
