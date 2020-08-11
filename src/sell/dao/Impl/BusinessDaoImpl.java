package sell.dao.Impl;




import sell.dao.BusinessDao;
import sell.doamain.Business1;
import sell.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/9 19:00
 */
public class BusinessDaoImpl implements BusinessDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<Business1> listBusiness(String businessName, String businessAddress) {
        List<Business1> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1 ");
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Business1 business = new Business1();
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
    public void saveBusiness(String businessName, String businessAddress) {
        String sql = "insert into business(businessName,password) values(?,'123456')";
        try {
            conn = JDBCUtils.getConnection();
            pstmt.setString(1,businessName);
            pstmt.executeUpdate();


            } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }


    }


    @Override
    public void updateBusiness(String businessName) {
        String sql = "update business set businessName = ?";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,businessName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }

    }

    @Override
    public void removeBusiness(String businessName) {
        String sql = "delete from business where businessName = ?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,businessName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }
    }


}
