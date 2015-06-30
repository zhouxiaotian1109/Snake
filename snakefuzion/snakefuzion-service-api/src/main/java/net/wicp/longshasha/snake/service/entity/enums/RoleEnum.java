package net.wicp.longshasha.snake.service.entity.enums;

/**
 * @Title: OrgInfoIsCustServe.java
 * @Package com.olymtech.cp.weixin.manage.enums
 * @Description: 用户是否已开通多客服服务 WxOrgInfo.IsCustomerService 字段
 * @author wishine周文
 * @date 2015年2月28日 下午2:51:39
 * @version V1.0
 */
public enum RoleEnum implements BaseEnum<RoleEnum> {

	SuperAdmin("超级管理员", 0), Admin("管理员", 1), Normal("普通用户", 1), ;

	private Integer propNo;
	private String propName;

	private RoleEnum(String name, Integer no) {
		this.propNo = no;
		this.propName = name;
	}

	@Override
	public Integer getNo() {
		return propNo;
	}

	@Override
	public String getName() {
		return propName;
	}

	@Override
	public RoleEnum getProperty(Integer value) {
		switch (value) {
		case 0:
			return SuperAdmin;
		case 1:
			return Admin;
		case 2:
			return Normal;
		default:
			throw new RuntimeException("没有合适的属性(No properties fund)");
		}
	}
}
