package sell.dao.Impl;

import com.company.domain.Admin;
import sell.dao.AdminDao;
import sell.doamain.Admin1;
import sell.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lbf
 * @date 2020/8/9 15:57
 */
public class AdminDaoImpl implements AdminDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public Admin1 getAdminNamePassword(String adminName, String password) {
        String sql = "select * from admin where adminName = ? and password = ?";
        Admin1 admin = null;
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setString(2, password);
            System.out.println(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                admin = new Admin1();
                admin.setAdminId(rs.getInt(1));
                admin.setAdminName(rs.getString(2));
                admin.setPassword(rs.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return admin;
    }

    @Override
    public void saveAdmin(Admin1 admin1) {
        String sql = "insert into admin values(null,?,?)";
        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, admin1.getAdminName());
            pstmt.setString(2, admin1.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
    }

    @Override
    public void updateAdmin(Admin1 admin1) {
        String sql = " update admin set adminName = ? where password =?";
        try {
            conn = pstmt.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, admin1.getAdminName());
            pstmt.setString(2, admin1.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pstmt, conn);
        }
    }

    @Override
    public void removeAdmin(String adminName) {
        String sql = " delete from admin where adminName = ? ";
        try {
            conn = pstmt.getConnection();
            pstmt.setString(1,adminName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }
    }


}
