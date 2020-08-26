package com.course.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.example.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	
}
