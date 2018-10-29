package com.java.repository;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.dto.Account;
import com.java.exception.DatabaseException;

@Repository
@Transactional(propagation=Propagation.REQUIRED, rollbackFor=DatabaseException.class,timeout=5, transactionManager="txManager")
public class AccountRepositoryImpl implements AccountRepository{

	@Autowired HibernateTemplate template;
	@Override
	public void addAccount(Account p) {
		template.save(p);
		
	}

	@Override
	public void deleteAccount(Account p) {
		template.delete(p);
	}

	@Override
	public void updateAccount(Account p) {
		template.update(p);
	}

	@Override
	public boolean withdrawMoney(int accountNumber, float withdrawlAmount) {
		Account ac=template.get(Account.class, accountNumber); //500
		float accountBalance= ac.getBalance();
		if(accountBalance>=withdrawlAmount) {
			ac.setBalance(accountBalance-withdrawlAmount); //0 // 300
		}else {
			return false;
		}
		template.update(ac); //0
		return true;
	}
	
	public boolean depositMoney(int accountNumber, float deposit) throws DatabaseException {
		Account ac=template.get(Account.class, accountNumber);
		float accountBalance= ac.getBalance();
		ac.setBalance(accountBalance+ deposit);
		template.update(ac);
		throw new DatabaseException("Account locked!");
	}
	
	@Override
	public Account getAccount(int id) {
		return template.get(Account.class, id);
	}

	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE)
	public List<Account> getAllAccounts() {
		return (List<Account>) template.findByCriteria(DetachedCriteria.forClass(Account.class));
	}

}
