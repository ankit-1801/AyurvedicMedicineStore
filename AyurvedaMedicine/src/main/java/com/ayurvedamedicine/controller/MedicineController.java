package com.ayurvedamedicine.controller;

import com.ayurvedamedicine.entities.Medicine;
//import com.ayurvedamedicine.entities.User;
//import com.ayurvedamedicine.repository.IMedicineRepository;
import com.ayurvedamedicine.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/medi")
public class MedicineController {
    @Autowired
    private IMedicineService iMedicineService;

    @PostMapping("/create")
    public ResponseEntity<String> createMed(@RequestBody Medicine m) throws IOException {
        return new ResponseEntity<>(iMedicineService.add(m), HttpStatus.OK);
    }

    @PatchMapping("/update/{medId}")
    public ResponseEntity<String> updateMed(@PathVariable("medId") Integer medId, @RequestBody Medicine med){
        return new ResponseEntity<>(iMedicineService.update(med, medId), HttpStatus.OK);
    }

    @GetMapping("/read/{medId}")
    public ResponseEntity<Medicine> readMed(@PathVariable("medId") Integer medId){
        return new ResponseEntity<>(iMedicineService.read(medId), HttpStatus.OK);
    }

    @GetMapping("/readAll")
    
    public List<Medicine> readAllMed(){
        return iMedicineService.readAll();
    }

    @DeleteMapping("/del/{medId}")
    private void deleteMed(@PathVariable("medId") Integer medId){
        iMedicineService.delete(medId);
    }

}

