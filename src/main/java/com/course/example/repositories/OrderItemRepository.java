package com.course.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.example.entities.OrderItem;
import com.course.example.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>
{
	
}
