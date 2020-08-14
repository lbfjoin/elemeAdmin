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
        if (businessName!= null && !businessName.equals("")){
           sql.append(" and businessName like '%").append(businessName).append( "%'");
            System.out.println(sql);
        }
        if (businessAddress !=null && !businessAddress.equals("")){
            sql.append(" and businessAddress like '%").append(businessAddress).append("%'");
            System.out.println(sql);
        }
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
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
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

        return list;
    }

    @Override
    public void saveBusiness(Business business) {
        String sql = "insert into business(businessName,password) values(?,123) ";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,business.getBusinessName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }

    }

    @Override
    public void updateBusiness(Business business) {
        String sql = "update business set businessExplain = ? where businessId = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,business.getBusinessExplain());
            pstmt.setInt(2,business.getBusinessId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }

    }

    @Override
    public void removeBusiness(Business business) {

    }
}
