package cn.edu.tju.scs.fm.dao.impl;

import cn.edu.tju.scs.fm.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
  转账案例的业务层实现类 
  **/
@Repository
public class AccountDaoImp  implements AccountDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void outMoney(String out,Double money){
		
		String sql = "update account set money = money - ? where name = ?";
		
		jdbcTemplate.update(sql,money,out);
	}
	
	public void inMoney(String in,Double money){
		
		String sql = "update account set money = money + ? where name = ?";
		
		jdbcTemplate.update(sql,money,in);
	}
	

}