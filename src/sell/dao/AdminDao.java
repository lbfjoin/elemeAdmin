package sell.dao;

import sell.domain.Admin;

public interface AdminDao {
    public Admin getAdminByNameByPass(String adminName, String password);
    public void save(Admin admin);
    public void update(Admin admin);
    public void remove(Integer id);
}
