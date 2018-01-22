package com.wbb.interceptor;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.wbb.access.AccessChecker;

@Aspect
public class AccessControlAnnotationAspect {

	private List<AccessChecker> accessCheckers;

	public AccessControlAnnotationAspect(List<AccessChecker> accessCheckers) {
		this.accessCheckers = accessCheckers;
	}

	/**
	 * 检查是否有权限，对于方法的注解。
	 * 
	 * @param proceedingJoinPoint
	 * @param accessControl
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@within(accessControl)")
	public Object methodAnnotatedcheckAccess(ProceedingJoinPoint proceedingJoinPoint, AccessControl accessControl)
			throws Throwable {
		return checkAccess(proceedingJoinPoint, accessControl);
	}

	/**
	 * 检查是否有权限，对于类的注解。
	 * 
	 * @param proceedingJoinPoint
	 * @param accessControl
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "@annotation(accessControl)")
	public Object classAnnotatedCheckAccess(ProceedingJoinPoint proceedingJoinPoint, AccessControl accessControl)
			throws Throwable {
		return checkAccess(proceedingJoinPoint, accessControl);
	}

	private Object checkAccess(ProceedingJoinPoint proceedingJoinPoint, AccessControl accessControl) throws Throwable {
		for (AccessChecker accessChecker : accessCheckers) {
			if (accessChecker.denied(accessControl)) {
				return accessChecker.responseOfDeny(accessControl);
			}
		}
		return proceedingJoinPoint.proceed();
	}
}
