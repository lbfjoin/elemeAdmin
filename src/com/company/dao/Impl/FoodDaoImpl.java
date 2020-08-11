package com.company.dao.Impl;

import com.company.dao.FoodDao;
import com.company.domain.Business;
import com.company.domain.Food;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/7 16:00
 */
public class FoodDaoImpl implements FoodDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Food> listFood(Integer businessId) {
        List<Food> list = new ArrayList<>();
        String sql = "select * from food where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public void saveFood(Food food) {
        String sql = "insert into food(foodName,foodPrice,businessId) values (? , ?, ?)";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, food.getFoodName());
            pstmt.setDouble(2, food.getFoodPrice());
            pstmt.setInt(3,food.getBusinessId());
            pstmt.executeUpdate();
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }

    }

    @Override
    public void removeFood(Integer foodId) {
        String sql = "delete from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, foodId);
            pstmt.executeUpdate();
            System.out.println(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
    }

    @Override
    public void updateFood(Food food) {
        String sql = "update food set foodName = ? ,foodExplain = ? , foodPrice = ? where foodId = ?";
        try {
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

    @Override
    public Food getFoodById(Integer foodId) {
        String sql = "select * from food where foodId = ?";
        Food food = null;
        try {
            conn = pstmt.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,foodId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                food = new Food();
                food.setFoodId(rs.getInt(1));
                food.setFoodName(rs.getString(2));
                food.setFoodExplain(rs.getString(3));
                food.setFoodPrice(rs.getDouble(4));
                food.setBusinessId(rs.getInt(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return food;
    }
}
