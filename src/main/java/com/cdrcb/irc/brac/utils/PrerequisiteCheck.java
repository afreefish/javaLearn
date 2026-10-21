package com.cdrcb.irc.brac.utils;

import com.cdrcb.irc.brac.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 2、先决条件示例
 * 先决条件主要检查依赖关系。这里演示分配高级角色前，检查用户是否已拥有基础角色。
 */
public class PrerequisiteCheck {
    // 存储角色依赖关系：Key=高级角色, Value=必须先拥有的基础角色
    private Map<String, String> prerequisites = new HashMap<>();

    public PrerequisiteCheck() {
        // 定义规则：想当“经理”，必须先当“员工”
        prerequisites.put("Manager", "Employee");
        // 定义规则：想当“架构师”，必须先当“高级开发”
        prerequisites.put("Architect", "SeniorDev");
    }

    /**
     * 校验是否满足先决条件
     */
    public boolean checkPrerequisite(User user, String targetRole) {
        String requiredRole = prerequisites.get(targetRole);

        // 如果该角色没有设置先决条件，直接通过
        if (requiredRole == null) {
            return true;
        }

        if (!user.hasRole(requiredRole)) {
            System.out.println("❌ 先决条件违规：用户 " + user.getUsername() +
                    " 缺少基础角色 [" + requiredRole + "]，无法分配 [" + targetRole + "]");
            return false;
        }

        System.out.println("✅ 先决条件满足：用户已拥有 [" + requiredRole + "]");
        return true;
    }
}
