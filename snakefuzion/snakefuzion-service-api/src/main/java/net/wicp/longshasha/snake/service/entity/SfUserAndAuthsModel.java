package net.wicp.longshasha.snake.service.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @project snakefuzion-service-api
 * @classpath net.wicp.longshasha.snake.service.entity.SfUserAndAuthModel
 * @author 陈雨清 2015年6月29日 下午10:00:08
 */

public class SfUserAndAuthsModel implements Serializable{

	private static final long serialVersionUID = 4223230220703251160L;
	
	private SfUser user;
	
	private List<SfAuth> auths;

	/**
	 * @return the user
	 */
	public SfUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(SfUser user) {
		this.user = user;
	}

	/**
	 * @return the auths
	 */
	public List<SfAuth> getAuths() {
		return auths;
	}

	/**
	 * @param auths the auths to set
	 */
	public void setAuths(List<SfAuth> auths) {
		this.auths = auths;
	}
	
	
}
