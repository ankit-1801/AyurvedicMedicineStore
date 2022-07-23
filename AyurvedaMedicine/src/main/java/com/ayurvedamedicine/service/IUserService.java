package com.ayurvedamedicine.service;

import com.ayurvedamedicine.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    public User add(User user);
    public User signIn(User user);
    public String update(User user, Integer id);
    public String delete(Integer id);
    public User read(Integer id);
    public List<User> readAll();
}
