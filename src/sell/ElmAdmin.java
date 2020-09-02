package sell;

import com.company.domain.Admin;
import com.company.view.AdminView;
import com.company.view.Impl.AdminViewImpl;
import sell.view.Impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/14 19:22
 */
public class ElmAdmin {
    public static void main(String[] args) {
        work();
    }

    public static void work() {
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------------------------------");
        System.out.println("|\t\t\t饿了么控制台版后台管理系统v1.0\t\t\t|");
        System.out.println("----------------------------------------------------");

        //调用登陆方法
        AdminView adminView = new AdminViewImpl();
        Admin admin = adminView.login();
        BusinessViewImpl view = new BusinessViewImpl();
        if (admin != null){
            int menu = 0;
            System.out.println("欢迎来到饿了么商家管理系统~");
            while (menu!=5){
                System.out.println("========= 1.所有商家列表=2.搜索商家=3.新建商家=4.删除商家=5.退出系统 =========");
                System.out.println("请选择相应的菜单编号");
                menu = input.nextInt();
                switch (menu){
                    case 1:
                        view.listBusinessAll();
                        break;
                    case 2:
                        view.listBusinessBySearch();
                        break;
                    case 3:
                        view.saveBusiness();
                        break;
                    case 4:
                        view.removeBusiness();
                        break;
                    case 5:
                        System.out.println("========= 欢迎下次光临饿了么系统 =========");
                        break;
                    default:
                        System.out.println("+++++++");
                        break;
                }
            }
        }
        else
            System.out.println("密码或用户名错误，请重新输入");
    }
}
