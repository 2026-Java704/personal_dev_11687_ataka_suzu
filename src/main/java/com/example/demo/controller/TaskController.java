package com.example.demo.controller;

import java.sql.Date;

//import java.util.List;
//
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.entity.Exercise;
//import com.example.demo.repository.ExerciseRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Exercise;
import com.example.demo.repository.ExerciseRepository;

@Controller
public class TaskController {

	private final ExerciseRepository exerciseRepository;

	TaskController(ExerciseRepository exerciseRepository) {
		this.exerciseRepository = exerciseRepository;
	}
	//	private final ExerciseRepository exerciseRepository;
	//
	//	public TaskController(ExerciseRepository exerciseRepository) {
	//		this.exerciseRepository = exerciseRepository;
	//	}
	//
	//	@GetMapping("/records/add")
	//	public String event(Model model) {
	//		List<Exercise> exerciseList = exerciseRepository.findAll();
	//		model.addAttribute("insert", exerciseList);
	//		return "insert";
	//	}

	@GetMapping("/records/add")
	public String index() {
		return "insert";
	}

	@PostMapping("/records/add")
	public String enter(@RequestParam(defaultValue = "") Integer time,
			@RequestParam(defaultValue = "") Integer weight,
			@RequestParam(defaultValue = "") Date date,
			@RequestParam(defaultValue = "") Integer event_id,
			Model model) {

		Exercise exercise = new Exercise(time, weight, date, event_id);
		exerciseRepository.save(exercise);
		return "redirect:/calorie";
	}

}
