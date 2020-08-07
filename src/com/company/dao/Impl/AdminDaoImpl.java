package com.company.dao.Impl;

import com.company.dao.AdminDao;
import com.company.domain.Admin;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author lbf
 * @date 2020/8/7 9:48
 */
public class AdminDaoImpl implements AdminDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public Admin getAdminByNameByPass(String adminName, String password) {
        String sql = "select * from admin where adminName = ? and password = ?";
        Admin admin = null;

        try {
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,adminName);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();

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
}
