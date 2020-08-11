package sell.dao;

import com.company.domain.Admin;
import sell.doamain.Admin1;

import java.util.List;

public interface AdminDao {
    public Admin1 getAdminNamePassword(String adminName, String password);
    public void saveAdmin(Admin1 admin1);
    public void updateAdmin(Admin1 admin1);
    public void removeAdmin(String adminName);
}
