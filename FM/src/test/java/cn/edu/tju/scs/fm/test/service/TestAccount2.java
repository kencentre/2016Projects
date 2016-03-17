package cn.edu.tju.scs.fm.test.service;

import javax.annotation.Resource;

import cn.edu.tju.scs.fm.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * Spring 声明式事务管理第二种：基于AspectJ的xml配置方式
 * @author jack
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAccount2 {
	
	/**
	 * 一定要注入代理类，代理类才会进行事务增强
	 */
	@Resource(name="accountService")
	private AccountService accountService;

	
	@Test
	public void testAccountService() {
		accountService.transfer("a", "b", 100d);
	}
	
	
}
