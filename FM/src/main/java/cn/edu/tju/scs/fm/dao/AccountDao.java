package cn.edu.tju.scs.fm.dao;

/**
  转账案例的业务层实现类 
  **/

public interface AccountDao{
	
	public void outMoney(String out, Double money);
	
	public void inMoney(String in, Double money);
	
}