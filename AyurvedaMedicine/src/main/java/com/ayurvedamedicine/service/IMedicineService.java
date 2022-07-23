package com.ayurvedamedicine.service;

import com.ayurvedamedicine.entities.Medicine;

import java.util.List;

public interface IMedicineService {

    public String add(Medicine medicine);
    public String update(Medicine medicine, Integer id);
    public String delete(Integer id);
    public Medicine read(Integer id);
    public List<Medicine> readAll();
}
