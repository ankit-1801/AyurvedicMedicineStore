package com.ayurvedamedicine.repository;

import com.ayurvedamedicine.entities.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Integer> {
	@Query(value = "SELECT * FROM orders WHERE user_id = :customerId",nativeQuery = true)
    List<Order> findByUserId(@Param("customerId") int customerId);
}
