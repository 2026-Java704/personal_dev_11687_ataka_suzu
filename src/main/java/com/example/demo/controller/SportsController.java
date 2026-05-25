package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Events;
import com.example.demo.model.Account;
import com.example.demo.repository.EventsRepository;

@Controller
public class SportsController {
	private final Account account;
	private final EventsRepository eventsRepository;

	public SportsController(Account account, EventsRepository eventsRepository) {
		this.account = account;
		this.eventsRepository = eventsRepository;
	}

	@GetMapping("/sports")
	public String list(Model model) {
		if (account.getId() == null) {
			return "redirect:/login";
		}
		List<Events> sportsList = eventsRepository.findByUserIdOrderByIdAsc(account.getId());
		model.addAttribute("sportsList", sportsList);

		return "sports";
	}
}
