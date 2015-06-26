package net.wicp.longshasha.snake.restapi;

import javax.annotation.Resource;

import net.wicp.longshasha.snake.service.api.IUserService;
import net.wicp.longshasha.snake.service.entity.SfUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project snakefuzion-service
 * @classpath net.wicp.longshasha.snake.restapi.UserCtrl
 * @author 陈雨清 2015年6月25日 下午6:10:20
 */
@Controller
public class UserCtrl {
	@Resource
	IUserService iUserService;

	@RequestMapping("/insertuser")
	@ResponseBody
	public int insertUser() {
		SfUser user = new SfUser();
		user.setUserAccount("c19967346");
		user.setUserPwd("123456");
		user.setUserNickName("洗澡狂魔");
		user.setUserName("陈雨清");
		int result = iUserService.insertUser(user);
		System.out.println(result);
		return result;
	}
}
