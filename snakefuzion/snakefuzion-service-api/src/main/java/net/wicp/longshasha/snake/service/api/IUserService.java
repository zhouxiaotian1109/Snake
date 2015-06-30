package net.wicp.longshasha.snake.service.api;

import java.util.List;
import java.util.Map;

import net.wicp.longshasha.snake.service.entity.SfAuth;
import net.wicp.longshasha.snake.service.entity.SfUser;
import net.wicp.longshasha.snake.service.entity.SfUserAndAuthsModel;

/**
 * @project snakefuzion-service-api
 * @classpath net.wicp.longshasha.snake.service.api.IUserService
 * @author 陈雨清 2015年6月25日 上午12:46:13
 */

public interface IUserService {
	Integer insertUser(SfUser user);

	List<SfUser> queryUsersByExample(SfUser user);

	List<SfUser> queryUsersByCondition(Map<String, Object> condition);

	Integer insertUsersBatch(List<SfUser> users);

	Integer insertAuthsBatch(List<SfAuth> auths);

	Integer insertUserAndAuths(SfUserAndAuthsModel model);
}
