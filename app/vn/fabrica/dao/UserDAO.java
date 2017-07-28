package vn.fabrica.dao;

import vn.fabrica.dto.User;
import vn.fabrica.utils.PagerUtil;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
	
	public int count();
	
	public List<User> all(@Param("pager") PagerUtil pager);

    public User getUserById(Integer id);
    
    public void insert(User user);
    
    public void update(@Param("id") Integer id, @Param("user") User user);
    
    public int delete(Integer id);
}
