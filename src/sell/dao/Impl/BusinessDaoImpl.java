package sell.dao.Impl;


import sell.dao.BusinessDao;

import sell.domain.Business;
import sell.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/12 20:28
 */
public class BusinessDaoImpl implements BusinessDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        ArrayList<Business> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")) {
            sql.append(" and businessName like '%").append(businessName).append("%'");
            System.out.println(sql);
        }
        if (businessAddress != null && !businessAddress.equals("")) {
            sql.append(" and businessAddress like '%").append(businessAddress).append("%'");
            System.out.println(sql);
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setBusinessId(rs.getInt(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStarPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
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
    public void saveBusiness(Business business) {
        String sql = "insert into business(businessName,password) values(?,123) ";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, business.getBusinessName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }

    }

    @Override
    public void updateBusiness(Business business) {
        String sql = "update business set businessExplain = ? where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, business.getBusinessExplain());
            pstmt.setInt(2, business.getBusinessId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }

    }

    @Override
    public void removeBusiness(Business business) {
        String sql = "delete from business where businessId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, business.getBusinessId());
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
            conn = com.company.utils.JDBCUtils.getConnection();
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
            com.company.utils.JDBCUtils.close(rs, pstmt, conn);
        }
        return business;
    }


    //查看商家信息
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
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return business;
    }
//更新商家信息
    @Override
    public void updateBusinessByBusinessId(Business business) {
        String sql = "update business set businessName = ?, " +
                "businessAddress =?,businessExplain=?" +
                ",starPrice=?,deliveryPrice=? where businessId = ? ";
        try {
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
            JDBCUtils.close(rs,pstmt,conn);
        }

    }
//更改商家密码
    @Override
    public void updateBusinessPassword(Integer businessId, String password) {
        String sql = "update business set  password = ? where businessId = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,password);
            pstmt.setInt(2,businessId);
            System.out.println(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
