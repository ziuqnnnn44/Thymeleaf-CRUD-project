package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.luv2code.springboot.thymeleafdemo.dao.FoodRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Food;

@Service
public class FoodServiceImpl implements FoodService{
	
	private FoodRepository foodRepository;

	@Autowired
	public FoodServiceImpl(FoodRepository theFoodRepository) {
		foodRepository = theFoodRepository;
	}

	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return foodRepository.findAll();
	}

	@Override
	public Food findById(int theId) {
		// TODO Auto-generated method stub
		Optional <Food> result = foodRepository.findById(theId);
		
		Food theFood = null;
		
		if (result.isPresent()) {
			theFood = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find food id - " + theId);
		}
		
		return theFood;
	}

	@Override
	public void save(Food theFood) {
		// TODO Auto-generated method stub
		foodRepository.save(theFood);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		foodRepository.deleteById(theId);
	}

}
