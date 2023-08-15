package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.luv2code.springboot.thymeleafdemo.entity.Food;

import com.luv2code.springboot.thymeleafdemo.service.FoodService;

@Controller
@RequestMapping("/foods")
public class FoodController {

	private FoodService foodService;
	
	public FoodController(FoodService theFoodService) {
		foodService= theFoodService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		
		List<Food> theFoods = foodService.findAll();
		// add to the spring model
		theModel.addAttribute("foods", theFoods);

		return "foods/list-foods";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		
		Food theFoods = new Food();
		// add to the spring model
		theModel.addAttribute("foods", theFoods);
		
		//theEmplyees.setFirstName("dor");

		return "foods/food-form";
	}
	@PostMapping("/save")
	public String saveFood(@ModelAttribute("foods") Food theFood) {
		
		
		foodService.save(theFood);

		
		return "redirect:/foods/list";
    }
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("foodId")int theId ,Model theModel) {

		
		Food theFood = foodService.findById(theId);
		
		
		
		theModel.addAttribute("foods", theFood);
		

		return "foods/food-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("foodId")int theId) {

		
		foodService.deleteById(theId);
		
	
		return "redirect:/foods/list";
	}
}
