package com.course.example.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.course.example.entities.Product;
import com.course.example.repositories.ProductRepository;
import com.course.example.services.DatabaseException.DatabaseException;
import com.course.example.services.exceptions.ResourceNotFoundException.ResourceNotFoundException;

@Service
public class ProductService
{	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	
	public Product findById(Long id)
	{
		Optional<Product> obj = repository.findById(id);
		return  obj.get();
	}
	
	public Product insert(Product obj)
	{
		return repository.save(obj);
	}
	
	public void delete(Long id)
	{
		try
		{
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e)
		{
			throw new ResourceNotFoundException(id);
		}
		
		catch (DataIntegrityViolationException e)
		{
			throw new DatabaseException(e.getMessage());
		}
		
		catch (EntityNotFoundException e)
		{
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj)
	{
		try
		{
			Product entity = repository.getOne(id);
			updateData(entity, obj);
			
			return repository.save(entity);
		}
		catch (Exception e)
		{
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product entity, Product obj)
	{
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setImgUrl(obj.getImgUrl());
	}
}
