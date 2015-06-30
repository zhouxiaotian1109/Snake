package net.wicp.longshasha.snake.restapi;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.wicp.longshasha.snake.service.api.IUserService;
import net.wicp.longshasha.snake.service.entity.SfAuth;
import net.wicp.longshasha.snake.service.entity.SfUser;
import net.wicp.longshasha.snake.service.entity.SfUserAndAuthsModel;
import net.wicp.longshasha.snake.service.entity.enums.RoleEnum;

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
	@RequestMapping("/insertUserAndAuths")
	@ResponseBody
	public int insertUserAndAuths() {
		SfUser user = new SfUser();
		user.setUserAccount("lss123456");
		user.setUserPwd("123456");
		user.setUserNickName("看得见的傻");
		user.setUserName("龙沙沙");
		user.setUserRole(RoleEnum.Normal.getName());
		
		
		SfAuth auth1=new SfAuth();
		auth1.setAuthName("增加");
		auth1.setAuthDiscribe("否");
		
		SfAuth auth2=new SfAuth();
		auth2.setAuthName("删除");
		auth2.setAuthDiscribe("否");
		
		SfAuth auth3=new SfAuth();
		auth3.setAuthName("修改");
		auth3.setAuthDiscribe("否");
		
		SfAuth auth4=new SfAuth();
		auth4.setAuthName("查询");
		auth4.setAuthDiscribe("是");
		
		List<SfAuth> auths=new ArrayList<SfAuth>();
		auths.add(auth1);
		auths.add(auth2);
		auths.add(auth3);
		auths.add(auth4);
		
		SfUserAndAuthsModel model=new SfUserAndAuthsModel();
		model.setAuths(auths);
		model.setUser(user);
		
		Integer result=iUserService.insertUserAndAuths(model);
		System.out.println("result:"+result);
		return result;
	}
}
