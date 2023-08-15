package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Food;

public interface FoodService {

	List<Food> findAll();
	
	Food findById(int theId);
	
	void save(Food theFood);
	
	void deleteById(int theId);
}
