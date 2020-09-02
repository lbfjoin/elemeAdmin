package sell;

import com.company.view.FoodView;
import com.company.view.Impl.FoodViewImpl;
import sell.dao.Impl.BusinessDaoImpl;
import sell.domain.Business;
import sell.view.Impl.BusinessViewImpl;

import java.util.Scanner;

/**
 * @author lbf
 * @date 2020/8/15 19:52
 */
public class BusinessAdmin {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        work();
    }

    public static void work() {

        System.out.println("----------------------------------------------------");
        System.out.println("|\t\t\t饿了么控制台版后台管理系统v1.0\t\t\t|");
        System.out.println("----------------------------------------------------");
        BusinessViewImpl view = new BusinessViewImpl();
        Business business = view.login();
        if (view!= null){
            int menu =0;
            System.out.println("欢迎来到饿了么商家管理系统~");

        while (menu != 5) {
            //创建一个菜单
            System.out.println("=========一级菜单（商家管理） 1.查看商家信息=2修改商家信息=3.更新密码=4.所属商品管理=5.退出系统 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    view.showBusinessInfo(business.getBusinessId());
                    break;
                case 2:
                    view.updateBusinessInfo(business.getBusinessId());
                    break;
                case 3:
                    view.updateBusinessPassword(business.getBusinessId());
                    break;
                case 4:
                    foodManage(business.getBusinessId());

                    break;
                case 5:
                    System.out.println("========= 欢迎下次光临饿了么系统 =========");
                    break;
                default:
                    System.out.println("========= 没有此菜单项 =========");
                    break;
            }
        }

    } else {
        System.out.println("账号或密码错误请重新输入");
    }

}
    private static void foodManage(int businessId) {
        FoodView foodView = new FoodViewImpl();
        int menu = 0;
        while (menu != 5) {
            // 创建一个菜单
            System.out.println("========= 二级菜单（美食管理）1.查看食品列表2.新增食品 3.修改食品=4.删除食品=5.返回一级菜单 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();

            switch (menu) {
                case 1:
                    foodView.listFoodAll(businessId);
                    break;
                case 2:
                    foodView.saveFood(businessId);
                    break;
                case 3:
                    foodView.updateFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;

            }
        }
    }

    }

