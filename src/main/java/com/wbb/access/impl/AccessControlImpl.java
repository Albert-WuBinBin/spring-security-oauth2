package com.wbb.access.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wbb.access.AccessChecker;
import com.wbb.interceptor.AccessControl;

public class AccessControlImpl implements AccessChecker {

	public boolean denied(AccessControl accessControl) {
		if (accessControl.requireCheck()) {
			if (!getLoginUser()) {
				return true;
			}
		}
		return false;
	}

	public Object responseOfDeny(AccessControl accessControl) {
		if (accessControl.requireCheck()) {
			if (!getLoginUser()) {
				return "Account does not match";
			}

		}
		return null;
	}

	/**
	 * 模拟登陆名验证，成功返回true，否则false
	 * 
	 * @return
	 */
	public boolean getLoginUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			// 根据spring security获取到的用户的登录名
			String loginName = authentication.getName();
			if (loginName.equals("admin")) {
				return true;
			}
		}
		return false;
	}

}
