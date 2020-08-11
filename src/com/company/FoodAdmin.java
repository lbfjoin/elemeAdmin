package com.company;

import com.alibaba.druid.support.json.JSONUtils;
import com.company.domain.Admin;
import com.company.view.Impl.AdminViewImpl;
import com.company.view.Impl.FoodViewImpl;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/8 17:31
 */
public class FoodAdmin {
    public static void main(String[] args) {
        work();
    }
    public static void work(){
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("\t\t\t欢迎来到商家菜单管理系统\t\t\t");
        System.out.println("----------------------------");

        AdminViewImpl adminView = new AdminViewImpl();
        Admin admin = adminView.login();
        FoodViewImpl view = new FoodViewImpl();
        if (admin != null){
            int menu = 0;
            System.out.println("欢迎查看菜单");
            while (menu!=5){
                System.out.println("========= 1.所有食物列表=2.搜索食物=3.新建食物=4.删除食物=5.退出系统 =========");
                System.out.println("请选择相应菜单序号");
                 menu = input.nextInt();
                 switch (menu){
                     case 1:
//                         view.listFoodAll();
                         break;
                     case 2:
//                         view.listFoodBySearch();
                         break;
                     case 3:
//                         view.saveFood();
                         break;
                     case 4:
//                         view.removefood();
                         break;
                     case 5:
                         System.out.println("欢迎下次进行点菜");
                         break;
                     default:
                         System.out.println("没有此菜单项，请重新选择");
                         break;
                 }
            }
        }else {
            System.out.println("用户名或密码输入错误");
        }
    }

}
