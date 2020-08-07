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
    public List<Business> listBusiness(String foodName, String foodExplain) {
        List<Food> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from food where 1 = 1");
        if (foodName != null && foodName.equals("")){
            sql.append("and foodName like '%").append(foodName).append("%'");
            System.out.println(sql);
        }
        if (foodExplain != null && foodExplain.equals("")){
            sql.append("and foodExplain like '%").append(foodExplain).append("%'");
            System.out.println(sql);
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Food food = new Food();
               food.setFoodId(rs.getInt("foodId"));
               food.setFoodName(rs.getString("foodNameq"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
