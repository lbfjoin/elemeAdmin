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
        System.out.println("------增加信息--------");

//        Admin admin1 = new Admin(2, "lisi", "333");
//        Admin admin2 = new Admin(3, "wangwu", "333");
//        adminDao.save(admin1);
//        adminDao.save(admin2);
//        Admin lisi = adminDao.getAdminByNameByPass("lisi", "333");
//        Admin wangwu = adminDao.getAdminByNameByPass("wangwu", "333");
//        System.out.println(wangwu);
//        System.out.println(lisi);
        System.out.println("------删除信息--------");

        Admin admin3 = new Admin(null, "lisi", "123");
        adminDao.remove(16);
        Admin remove = adminDao.getAdminByNameByPass("lisi", "123");
        System.out.println(remove);
//
//        System.out.println("------修改信息--------");
//        Admin admin4 = new Admin(2, "wangwu", "333");
//        adminDao.update(admin4);
//        Admin update = adminDao.getAdminByNameByPass("wangwu", "333");
//        System.out.println(update);

    }
}
