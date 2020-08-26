package com.course.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.example.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
