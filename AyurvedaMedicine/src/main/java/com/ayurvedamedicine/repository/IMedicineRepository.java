package com.ayurvedamedicine.repository;

import com.ayurvedamedicine.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Integer> {
	
}
