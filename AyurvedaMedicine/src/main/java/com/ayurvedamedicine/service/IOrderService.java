package com.ayurvedamedicine.service;

import com.ayurvedamedicine.entities.Medicine;
import com.ayurvedamedicine.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IOrderService {
    @Autowired
    public String add(Order order);
    public String update(Order order, Integer id);
    public String delete(Integer id);
    public Order read(Integer id);
    public List<Order> getOrderByUserId(int customerId);
    public List<Order> readAll();
}