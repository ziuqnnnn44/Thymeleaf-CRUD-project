package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.luv2code.springboot.thymeleafdemo.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
