/**   
 * @Title: BaseEnum.java 
 * @Package com.olymtech.cp.weixin.manage.enums 
 * @Description: TODO 
 * @author wishine周文   
 * @date 2014年11月27日 下午2:55:16 
 * @version V1.0   
 */
package net.wicp.longshasha.snake.service.entity.enums;

/**
 * <pre>
 * 枚举类接口 
 * 添加泛型支持  fqs 2015/5/24
 * </pre>
 * 
 * @author wishine周文 、FQS
 * @date 2014年11月27日 下午2:55:16
 * @version V1.0
 * 
 */
public interface BaseEnum<T> {

	/**
	 * 获得属性的int值
	 * 
	 * @return： 属性int值，不等于枚举的Orgid
	 */
	public Integer getNo();

	/**
	 * 获得属性的解释，用于输出
	 * 
	 * @return： 属性的中文解释
	 */
	public String getName();

	/**
	 * 根据数值获得枚举值
	 * 
	 * @param value
	 *            : 枚举类型的数值，与数据库对应
	 * @return： 枚举值
	 */
	public T getProperty(Integer value);

}
