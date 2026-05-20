package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.model.Account;
import com.example.demo.repository.UsersRepository;

@Controller
public class UserController {
	private final HttpSession session;
	private final UsersRepository usersRepository;
	private final Account account;

	public UserController(HttpSession session,
			UsersRepository usersRepository,
			Account account) {
		this.session = session;
		this.usersRepository = usersRepository;
		this.account = account;
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
			return "login";
		}

		List<Users> userList = usersRepository.findByNameAndPassword(name, password);
		if (userList == null || userList.size() == 0) {
			model.addAttribute("message", "名前とパスワードが一致しませんでした");
			return "login";
		}
		Users users = userList.get(0);

		account.setId(users.getId());
		account.setName(users.getName());
		return "redirect:/records/add";
	}

	//新規会員登録
	@GetMapping("/users/new")
	public String create() {
		return "newlogin";
	}

	//登録ボタンをクリックしたときの処理
	@PostMapping("/users/add")
	public String add(
			@RequestParam String name,
			@RequestParam String password,
			Model model) {

		// エラーチェック
		List<String> errorList = new ArrayList<>();
		if (name.length() == 0) {
			errorList.add("名前は必須です");
		}
		if (password.length() == 0) {
			errorList.add("パスワードは必須です");
		}
		// 名前、パスワード存在チェック
		List<Users> userList = usersRepository.findByNameAndPassword(name, password);
		if (userList != null && userList.size() > 0) {
			// 登録済みのメールアドレスが存在した場合
			errorList.add("登録済みの名前、パスワードです");
		}

		// エラー発生時はお問い合わせフォームに戻す
		if (errorList.size() > 0) {
			model.addAttribute("errorList", errorList);
			model.addAttribute("name", name);
			model.addAttribute("password", password);
			return "newlogin";
		}

		Users user = new Users(name, password);
		usersRepository.save(user);

		return "redirect:/login";

	}

}
