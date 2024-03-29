package net.wicp.longshasha.snake.dao;

import java.util.List;
import java.util.Map;

import net.wicp.longshasha.snake.service.entity.SfAuth;
import net.wicp.longshasha.snake.service.entity.SfUser;

import org.springframework.stereotype.Repository;

/**
 * @project snakefuzion-service
 * @classpath net.wicp.longshasha.snake.dao.IUserDao
 * @author 陈雨清 2015年6月25日 上午12:43:38
 */
@Repository
public interface IUserDao {
	Integer insertUser(SfUser user);
	List<SfUser> queryUsers(Map<String, Object> condition);
	/**
	 * 
	 * @author 陈雨清 2015年6月29日 下午9:55:10
	 * @param users
	 * @return
	 */
	Integer insertUsersBatch(List<SfUser> users);
	/**
	 * 
	 * @author 陈雨清 2015年6月29日 下午9:55:25
	 * @param auths
	 * @return
	 */
	Integer insertAuthsBatch(List<SfAuth> auths);
}
