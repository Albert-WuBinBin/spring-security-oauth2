package com.wbb.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessControl {

	/**
	 * 是否进行权限检查
	 * 
	 * @return
	 */
	boolean requireCheck() default false;
}
