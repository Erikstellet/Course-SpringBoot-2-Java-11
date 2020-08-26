package com.course.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.example.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	
}
