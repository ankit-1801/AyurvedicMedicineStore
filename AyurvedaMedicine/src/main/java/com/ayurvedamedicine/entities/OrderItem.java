package com.ayurvedamedicine.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
 public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private Integer medicineId;

	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(medicineId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(medicineId, other.medicineId);
	}
    
}
