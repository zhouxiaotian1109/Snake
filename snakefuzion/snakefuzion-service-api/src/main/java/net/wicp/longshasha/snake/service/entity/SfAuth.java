package net.wicp.longshasha.snake.service.entity;

import java.io.Serializable;

/**
 * @project snakefuzion-service-api
 * @classpath net.wicp.longshasha.snake.service.entity.SfAuth
 * @author 陈雨清 2015年6月29日 下午9:41:09
 */

public class SfAuth implements Serializable {
	private static final long serialVersionUID = -3092417930050214068L;
	private Integer AuthId;
	private String AuthName;
	private String AuthDiscribe;//是,否
	
	/**
	 * @return the authId
	 */
	public Integer getAuthId() {
		return AuthId;
	}

	/**
	 * @param authId
	 *            the authId to set
	 */
	public void setAuthId(Integer authId) {
		AuthId = authId;
	}

	/**
	 * @return the authName
	 */
	public String getAuthName() {
		return AuthName;
	}

	/**
	 * @param authName
	 *            the authName to set
	 */
	public void setAuthName(String authName) {
		AuthName = authName;
	}

	/**
	 * @return the authDiscribe
	 */
	public String getAuthDiscribe() {
		return AuthDiscribe;
	}

	/**
	 * @param authDiscribe
	 *            the authDiscribe to set
	 */
	public void setAuthDiscribe(String authDiscribe) {
		AuthDiscribe = authDiscribe;
	}

}
