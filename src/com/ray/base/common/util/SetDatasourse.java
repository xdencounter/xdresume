package com.ray.base.common.util;

import org.aspectj.lang.JoinPoint;


/**
 * 描述：数据源动态设置
 *
 * Created by xuedong on 2016/12/16.
 */
public class SetDatasourse {

	/**
	 * 动态设置数据源
	 * @param jp JoinPoint 切入点参数
	 */
	public void setDynamicDatasource(JoinPoint jp) {
		DynamicDataSource.setCurrentLookupKey("read");
		String methodName = jp.getSignature().getName();

		//如果是枚举类中的方法，切换为写的数据源
	mark: 
		for (EnumConstant ec : EnumConstant.values()) {
			if (methodName.startsWith(ec.name())) {
				DynamicDataSource.setCurrentLookupKey("write");
				break mark;
			}
		}
	}
	
	
}
