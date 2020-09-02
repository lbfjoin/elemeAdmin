package sell.dao.Impl;

import sell.dao.FoodDao;
import sell.domain.Food;
import sell.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/14 21:04
 */
public class FoodDaoImpl implements FoodDao {
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
    @Override
    public List<Food> listFood(Integer businessId) {
        String sql = "select * from food where businessId = ?";
        ArrayList<Food> list = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            rs = pstmt.executeQuery();
            while (rs.next()){
              list = new ArrayList<>();
                Food food = new Food();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodExplain(rs.getString(3));
                food.setFoodPrice(rs.getDouble(4));
                food.setBusinessId(rs.getInt(5));
                list.add(food);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return list;
    }

    @Override
    public void saveFood(Food food) {
      String sql = "insert into food(foodName,foodPrice,businessId) values(?,?,?)  ";
      try {
          conn = JDBCUtils.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,food.getFoodName());
          pstmt.setDouble(2,food.getFoodPrice());
          pstmt.setInt(3,food.getBusinessId());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          JDBCUtils.close(null,pstmt,conn);
      }

    }

    @Override
    public void removeFood(Integer foodId) {
        String sql = "delete from  food where foodId =?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,foodId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }

    }

    @Override
    public void updateFood(Food food) {
      String sql = "update food set foodName = ?,foodExplain=?,foodPrice =? where foodId =?";
      try{
          conn = JDBCUtils.getConnection();
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,food.getFoodName());
          pstmt.setString(2,food.getFoodExplain());
          pstmt.setDouble(3,food.getFoodPrice());
          pstmt.setInt(4,food.getFoodId());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }finally {
          JDBCUtils.close(null,pstmt,conn);
      }
    }
}
