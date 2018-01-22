package com.wbb.access;

import com.wbb.interceptor.AccessControl;

public interface AccessChecker {

    /**
     * 检查是否有权限访问某项资源
     * @param accessControl
     * @return <code>true</code> if access denied, else <code>false</code>
     */
    boolean denied(AccessControl accessControl);

    /**
     * 如果没有权限，则终止请求，返回错误
     * @param accessControl
     * @return
     */
    Object responseOfDeny(AccessControl accessControl);
}
