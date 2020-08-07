package com.company.test;

import com.company.dao.Impl.AdminDaoImpl;
import com.company.domain.Admin;

/**
 * @author lbf
 * @date 2020/8/7 10:02
 */
public class TestAdmin {
    public static void main(String[] args) {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("zhangsan", "123");
        System.out.println(admin);
    }
}
