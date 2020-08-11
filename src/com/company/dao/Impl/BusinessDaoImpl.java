package com.company.dao.Impl;

import com.company.dao.BusinessDao;
import com.company.domain.Admin;
import com.company.domain.Business;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/7 14:53
 */
public class BusinessDaoImpl implements BusinessDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        if (businessName != null && !businessName.equals("")) {
            //传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%'");
            System.out.println(sql);
        }
        if (businessAddress != null && !businessAddress.equals("")) {
            // 传入了商家地址
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");
            System.out.println(sql);
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));

                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;


    }

    @Override
    public int saveBusiness(String businessName) {
        int businessId = 0;
        //附带初始密码
        String sql = "insert into business(businessName,password) values(?,'123456')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //可以在prepareStatement中设置返回自增长列的值
            pstmt.setString(1, businessName);
            pstmt.executeUpdate();

            //获取自增长的列
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                businessId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return businessId;

    }

    @Override
    public void updateBusiness(String businessName, Integer businessId) {
        String sql = "update business set businessName = ? where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, businessName);
            pstmt.setInt(2, businessId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
    }

    @Override
    public void removeBusiness(String businessName) {
        String sql = "delete from business where businessName = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, businessName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
    }

    @Override
    public Business getBusinewwByNameByPassword(Integer businessId, String password) {
        String sql = "select * from business where businessId = ? and password = ?";
        Business business = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setBusinessName(rs.getString(2));
                business.setPassword(rs.getString(3));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return business;
    }

    @Override
    public void selectBusiness(Integer businessId) {
        String sql = "select * from business where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                System.out.println(business);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

    }

    @Override
    public Business getBusinessByBusinessId(Integer businessId) {
        String sql = "select * from business where businessId = ?";
        Business business = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, businessId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);

        }
        return business;

    }

    @Override
    public void updateBusinessByBusinessId(Business business) {
        String sql = "update business set businessName = ?, " +
                "businessAddress =?,businessExplain=?" +
                ",starPrice=?,deliveryPrice=? where businessId = ? ";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, business.getBusinessName());
            pstmt.setString(2, business.getBusinessAddress());
            pstmt.setString(3, business.getBusinessExplain());
            pstmt.setDouble(4, business.getStarPrice());
            pstmt.setDouble(5, business.getDeliveryPrice());
            pstmt.setInt(6, business.getBusinessId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

    }

    @Override
    public void updateBusinessPassword(Integer businessId,String password) {
        String sql = "update business set password = ? where businessId = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            System.out.println("222222222");
            pstmt.setString(1,password);
            pstmt.setInt(2,businessId);
            System.out.println("11111111");
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt, conn);
        }

    }
    }

