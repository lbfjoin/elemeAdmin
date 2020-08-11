package sell.dao.Impl;


import sell.dao.AdminDao;
import sell.domain.Admin;
import sell.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lbf
 * @date 2020/8/11 20:43
 */
public class AdminDaoImpl implements AdminDao {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        String sql = "select * from admin where adminName = ? and password = ?";
        Admin admin = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,adminName);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            System.out.println(sql);
            while (rs.next()){
                admin = new Admin();
                admin.setAdminId(rs.getInt(1));
                admin.setAdminName(rs.getString(2));
                admin.setPassword(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

        return admin;
    }

    @Override
    public void save(Admin admin) {

    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public void remove(Integer id) {

    }


}

