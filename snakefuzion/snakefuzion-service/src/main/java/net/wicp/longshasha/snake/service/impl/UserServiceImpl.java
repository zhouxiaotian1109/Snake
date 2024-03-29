package net.wicp.longshasha.snake.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.wicp.longshasha.snake.dao.IUserDao;
import net.wicp.longshasha.snake.service.api.IUserService;
import net.wicp.longshasha.snake.service.entity.SfAuth;
import net.wicp.longshasha.snake.service.entity.SfUser;
import net.wicp.longshasha.snake.service.entity.SfUserAndAuthsModel;
import net.wicp.longshasha.snake.service.entity.enums.RoleEnum;

import org.nutz.json.Json;
import org.springframework.stereotype.Service;

/**
 * @project snakefuzion-service
 * @classpath net.wicp.longshasha.snake.service.impl.SfUserServiceImpl
 * @author 陈雨清 2015年6月25日 上午12:50:57
 */
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	IUserDao iUserDao;

	@Override
	public Integer insertUser(SfUser user) {
		SfUser example = new SfUser();
		if (user != null) {
			example.setUserAccount(user.getUserAccount());
		}
		List<SfUser> users = queryUsersByExample(example);
		if (users != null && users.size() > 0) {
			return -2;// 已存在
		}
		return iUserDao.insertUser(user);
	}

	@Override
	public List<SfUser> queryUsersByExample(SfUser user) {
		Map<String, Object> condition = new HashMap<String, Object>();
		if (user != null) {
			condition.put("userId", user.getUserId());
			condition.put("userAccount", user.getUserAccount());
			condition.put("userName", user.getUserName());
			condition.put("userNickName", user.getUserNickName());
			condition.put("userPwd", user.getUserPwd());
		}
		return queryUsersByCondition(condition);
	}

	@Override
	public List<SfUser> queryUsersByCondition(Map<String, Object> condition) {
		return iUserDao.queryUsers(condition);
	}

	@Override
	public Integer insertUsersBatch(List<SfUser> users) {

		return iUserDao.insertUsersBatch(users);
	}

	@Override
	public Integer insertAuthsBatch(List<SfAuth> auths) {

		return iUserDao.insertAuthsBatch(auths);
	}

	@Override
	public Integer insertUserAndAuths(SfUserAndAuthsModel model) {
		SfUser user = model.getUser();
		List<SfAuth> auths = model.getAuths();
		int count = 0;
		for (SfAuth sfAuth : auths) {
			if ("是".equals(sfAuth.getAuthDiscribe())) {
				count++;
			}
		}

		if (count == 0) {
			user.setUserRole(RoleEnum.Normal.getName());
		} else if (count == auths.size()) {
			user.setUserRole(RoleEnum.SuperAdmin.getName());
		} else {
			user.setUserRole(RoleEnum.Admin.getName());
		}

		System.out.println("user:" + Json.toJson(user));
		System.out.println("auths" + Json.toJson(auths));
		System.out.println(this.insertUser(user));
		System.out.println(iUserDao.insertAuthsBatch(auths));

		return 1;
	}

}
