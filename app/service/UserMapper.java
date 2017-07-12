package service;

import model.User;

import java.util.List;

public interface UserMapper {
	public List<User> all();

    public User getUserById(Integer id);
    
    public void insert(User user);
    
    public void update(User user);
    
    public void delete(Integer userId);
}
