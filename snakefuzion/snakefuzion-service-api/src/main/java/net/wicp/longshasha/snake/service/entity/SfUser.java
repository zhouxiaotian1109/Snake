package net.wicp.longshasha.snake.service.entity;

import java.io.Serializable;

/**
 * @project snakefuzion-service-api
 * @classpath net.wicp.longshasha.snake.service.entity.SfUser
 * @author 陈雨清 2015年6月25日 上午12:48:15
 */
public class SfUser implements Serializable {

	private static final long serialVersionUID = -8589478431757851720L;

	private Integer userId;
	private String userAccount;
	private String userPwd;
	private String userNickName;
	private String userName;
	private String userRole;
	
 
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the userAccount
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount
	 *            the userAccount to set
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * @return the userPwd
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * @param userPwd
	 *            the userPwd to set
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * @return the userNickName
	 */
	public String getUserNickName() {
		return userNickName;
	}

	/**
	 * @param userNickName
	 *            the userNickName to set
	 */
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
