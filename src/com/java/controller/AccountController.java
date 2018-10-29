package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.Account;
import com.java.exception.DatabaseException;
import com.java.service.AccountService;

@Controller
public class AccountController {

	@Autowired AccountService service;
	@ResponseBody
	@GetMapping("/addAccount")
	public String addAccount(@RequestParam int accountNumber, @RequestParam float balance,
			@RequestParam int accountHolderId) {
		service.addAccount(new Account(accountNumber, balance, accountHolderId));
		return "added!";
	}
	@ResponseBody
	@GetMapping("/transferMoney")
	public String transferMoney(@RequestParam int fromAccount,
			@RequestParam int toAccount, @RequestParam float amount) throws DatabaseException {
		service.transferMoney(fromAccount, toAccount, amount);
		return "transferred";
	}
}
