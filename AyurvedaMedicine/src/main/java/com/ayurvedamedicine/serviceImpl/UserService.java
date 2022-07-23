package com.ayurvedamedicine.serviceImpl;

import com.ayurvedamedicine.entities.User;
import com.ayurvedamedicine.exception.UserNotFoundException;
import com.ayurvedamedicine.repository.IUserRepository;
import com.ayurvedamedicine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

//import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService  implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User add(User user) {

        return iUserRepository.save(user);
    }

    @Override
    public String update(User user, Integer id) {
        User u = iUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id= " + id + "is mot found"));
        boolean needUpdate = false;
        if (StringUtils.hasLength(user.getUserName())) {
            u.setUserName(user.getUserName());
            needUpdate = true;
        }
        if (StringUtils.hasLength(user.getUserPassword())) {
            u.setUserPassword(user.getUserPassword());
            needUpdate = true;
        }
        if (StringUtils.hasLength(user.getRole())) {
            u.setRole(user.getRole());
            needUpdate = true;
        }
        if (needUpdate) {
            iUserRepository.save(u);
            return "User updated successfully";
        }
        return "nothing to update";
    }

    @Override
    public String delete(Integer id) {
        iUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with id= " + id + "is mot found"));
        iUserRepository.deleteById(id);
        return "user deleted";
    }

    @Override
    public User read(Integer id) {
        User user = iUserRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user with this id" + id + "is not available"));
        return user;
    }

    @Override
    public List<User> readAll() {

        List<User> userList = new ArrayList<User>();
        iUserRepository.findAll().forEach(user -> userList.add(user));
        return userList;
    }

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		User user1 = iUserRepository.findByUserByIdPassword(user.getUserEmail(), user.getUserPassword());
		if(user1 == null) {
			throw new UserNotFoundException("Bad Credentials!!");
		}
		return user1;
	}
}