package com.java.repository;

import java.util.List;

import com.java.dto.Account;
import com.java.exception.DatabaseException;

public interface AccountRepository {
	
public void addAccount(Account p);
	
	public void deleteAccount(Account p);
	
	public void updateAccount(Account p);
	
	public Account getAccount(int id);
	
	public List<Account> getAllAccounts();

	public boolean withdrawMoney(int accountNumber, float withdrawlAmount);
	
	public boolean depositMoney(int accountNumber, float deposit) throws DatabaseException;
}
