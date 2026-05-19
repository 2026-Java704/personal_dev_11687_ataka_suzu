package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.model.Account;
import com.example.demo.repository.usersRepository;

@Controller
public class UserController {
	private final HttpSession session;
	private final Account account;
	private final usersRepository usersRepository;

	public UserController(HttpSession session, Account account, usersRepository usersRepository) {
		this.session = session;
		this.account = account;
		this.usersRepository = usersRepository;
	}

	//ログイン画面
	@GetMapping({ "/", "/login" })
	public String index() {
		session.invalidate();

		return "login";
	}

	//ログインを実行
	@PostMapping("/login")
	public String login(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {
		//名前が空の場合エラー
		if (name.length() == 0 || password.length() == 0) {
			model.addAttribute("message", "入力してください");

		}
		return "login";

	}

	@GetMapping("/users/new")
	public String create() {
		return "newlogin";
	}

	@PostMapping("/users/add")
	public String add(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {

		Users users = new Users(name, password);
		usersRepository.save(users);

		return "redirect:/";

	}
}
