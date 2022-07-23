package com.ayurvedamedicine.repository;

import com.ayurvedamedicine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IUserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM users WHERE user_email = :userEmail AND user_password =:userPassword",nativeQuery = true)
    User findByUserByIdPassword(@Param("userEmail") String userEmail ,@Param("userPassword") String userPassword);
}
