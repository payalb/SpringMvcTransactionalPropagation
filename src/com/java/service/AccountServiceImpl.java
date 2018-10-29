package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.exception.DatabaseException;
import com.java.repository.AccountRepository;

@Service
@Transactional(rollbackFor=DatabaseException.class, transactionManager="txManager")
public class AccountServiceImpl implements AccountService{

	@Autowired AccountRepository rep;
	@Override
	public void deleteAccount(Account p) {
		rep.deleteAccount(p);
		
	}

	@Override
	public void updateAccount(Account p) {
		rep.updateAccount(p);
		
	}

	@Override
	public Account getAccount(int id) {
		return rep.getAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return rep.getAllAccounts();
	}

	@Override
	public boolean withdrawMoney(int accountNumber, float withdrawlAmount) {
		return rep.withdrawMoney(accountNumber, withdrawlAmount);
	}

	@Override
	public boolean depositMoney(int accountNumber, float deposit) throws DatabaseException {
		return rep.depositMoney(accountNumber, deposit);
	}

	@Override
	public boolean transferMoney(int fromAccount, int toAccount, float amount) throws DatabaseException {
		if(rep.withdrawMoney(fromAccount, amount)) {
		return rep.depositMoney(toAccount, amount);
		}else {
			return false;
		}
	}

	@Override
	public void addAccount(Account p) {
		rep.addAccount(p);
	}
}
