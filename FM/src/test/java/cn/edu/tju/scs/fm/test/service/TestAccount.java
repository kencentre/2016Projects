package cn.edu.tju.scs.fm.test.service;

import cn.edu.tju.scs.fm.dao.CardDao;
import cn.edu.tju.scs.fm.service.AccountService;
import cn.edu.tju.scs.fm.test.base.UnitTestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;


/**
 * Spring 声明式事务管理第二种：基于AspectJ的xml配置方式
 * @author jack
 *
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAccount extends UnitTestBase {
	
	public TestAccount() {
		super("classpath:applicationContext.xml");
	}
	
	@Test
	public void testAccountService() {
	
		AccountService accountService = (AccountService)super.getBean("accountService");
		accountService.transfer("a", "b", 100d);
	}

	@Test
	public void testCardDao() {
		CardDao cardDao = (CardDao)super.getBean("cardDao");
//		cardDao.getAllCards();
		cardDao.getCard("123");
	}

	
}
