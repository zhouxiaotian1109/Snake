package net.wicp.longshasha.snake;

import javax.annotation.Resource;

import net.wicp.longshasha.snake.service.api.IUserService;
import net.wicp.longshasha.snake.service.entity.SfUser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @project snakefuzion-service
 * @classpath net.wicp.longshasha.snake.UserTest
 * @author 陈雨清 2015年6月25日 下午4:03:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/applicationContext.xml" })
public class UserTest  extends AbstractJUnit4SpringContextTests{
	@Resource
	private IUserService iUserService;

	/**
	 * 
	 * @author 陈雨清 2015年6月25日 下午4:03:37
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * 
	 * @author 陈雨清 2015年6月25日 下午4:03:37
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		SfUser user = new SfUser();
		user.setUserAccount("c19967346");
		user.setUserPwd("123456");
		user.setUserNickName("洗澡狂魔");
		user.setUserName("陈雨清");
		int result = iUserService.insertUser(user);
		System.out.println(result);
	}

}
