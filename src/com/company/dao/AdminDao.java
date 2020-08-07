package com.company.dao;

import com.company.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String userName,String password);
    public void save(Admin admin);
    public void update(Admin admin);
    public void remove(Integer id);
}
