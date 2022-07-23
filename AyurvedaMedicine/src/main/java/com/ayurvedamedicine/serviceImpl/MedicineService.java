package com.ayurvedamedicine.serviceImpl;

import com.ayurvedamedicine.entities.Medicine;

import com.ayurvedamedicine.exception.MedicineNotFoundException;
import com.ayurvedamedicine.repository.IMedicineRepository;
import com.ayurvedamedicine.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService implements IMedicineService {
    @Autowired
    private IMedicineRepository iMedicineRepository;

    @Override
    public String add(Medicine medicine) {
        iMedicineRepository.save(medicine);
        return "Medicine added successfully";
    }

    @Override
    public String update(Medicine medicine, Integer id) {
        Medicine med = iMedicineRepository.findById(id).orElseThrow(MedicineNotFoundException::new);
        boolean needUpdate = false;
        if(StringUtils.hasLength(medicine.getMedicineName())){
            med.setMedicineName(medicine.getMedicineName());
            needUpdate = true;
        }
        if(StringUtils.hasLength(medicine.getCompanyName())){
            med.setCompanyName(medicine.getCompanyName());
            needUpdate = true;
        }
//        Category update left

        if(medicine.getMedicineCost() != 0.0){
            med.setMedicineCost(medicine.getMedicineCost());
            needUpdate = true;
        }
        if(medicine.getMfd().isBefore(medicine.getExpiryDate())){
            med.setMfd(medicine.getMfd());
            needUpdate = true;
        }
        if(medicine.getExpiryDate().isAfter(medicine.getMfd())){
            med.setExpiryDate(medicine.getExpiryDate());
            needUpdate = true;
        }
        if(needUpdate) {
            iMedicineRepository.save(med);
            return "Product updated successfully";
        }
        return "Nothing to update";
    }


    @Override
    public String delete(Integer id) {
        iMedicineRepository.findById(id).orElseThrow(()->new MedicineNotFoundException("Medicine with id= "+id+" is not found"));
        iMedicineRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Medicine read(Integer id) {
        Medicine medicine = iMedicineRepository.findById(id).orElseThrow(MedicineNotFoundException::new);
        return medicine;
    }


    @Override
    public List<Medicine> readAll() {
        List<Medicine> medicineList=new ArrayList<Medicine>();
        iMedicineRepository.findAll().forEach(medicine -> medicineList.add(medicine));
        return medicineList;
    }

}
