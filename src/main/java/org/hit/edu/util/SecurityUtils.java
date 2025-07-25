package org.hit.edu.util;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    private Subject subject;

    public static class Subject {
        public boolean isPermitted(String permission) {
            // 这里应该实现实际的权限检查逻辑
            // 例如检查用户是否有device:connect权限
            return "device:connect".equals(permission);
        }
    }
    

    public Subject getSubject() {
        return this.subject;
    }
    
    
}