package cn.edu.tju.scs.fm.service.impl;

import cn.edu.tju.scs.fm.dao.AccountDao;
import cn.edu.tju.scs.fm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  转账案例的业务层实现类 
  **/

@Service()
public class AccountServiceImp implements AccountService {

    @Autowired
	private AccountDao accountDao;
	
	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}



	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}



	public void transfer(String out,String in,Double money){
		
		System.out.println("the transfer is begin:----------------");
		accountDao.outMoney(out, money);
		 int i = 1 / 0;
		accountDao.inMoney(in, money);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}