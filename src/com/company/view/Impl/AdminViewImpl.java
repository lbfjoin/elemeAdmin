package com.company.view.Impl;

import com.company.dao.AdminDao;
import com.company.dao.Impl.AdminDaoImpl;
import com.company.domain.Admin;
import com.company.view.AdminView;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/7 11:35
 */
public class AdminViewImpl implements AdminView {
    private Scanner input = new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入管理员的用户名");
        String adminName = input.next();
        System.out.println("请输入管理员的密码");
        String password = input.next();
        AdminDao dao = new AdminDaoImpl();
        return dao.getAdminByNameByPass(adminName, password);
    }
}
