package com.cdrcb.irc.brac.utils;

import com.cdrcb.irc.brac.pojo.Role;
import com.cdrcb.irc.brac.pojo.User;

public class RBACDemo {
    public static void main(String[] args) {
        // 1. 初始化数据
        User user = new User("张三");
        Role employeeRole = new Role("Employee");
        Role managerRole = new Role("Manager");
        Role architectRole = new Role("Architect");

        // 2. 初始化约束检查器
        CardinalityConstraint cardinality = new CardinalityConstraint(2); // 最多2个角色
        PrerequisiteCheck prerequisite = new PrerequisiteCheck();

        // 3. 测试先决条件：直接分配经理（应该失败）
        System.out.println("--- 测试1：尝试直接分配经理 ---");
        if (prerequisite.checkPrerequisite(user, "Manager")) {
            user.addRole(managerRole);
        }

        // 4. 测试正常流程：先分配员工
        System.out.println("\n--- 测试2：分配员工角色 ---");
        user.addRole(employeeRole);
        System.out.println("当前角色: " + user.getRoles());

        // 5. 测试先决条件：再次分配经理（应该成功）
        System.out.println("\n--- 测试3：再次尝试分配经理 ---");
        if (prerequisite.checkPrerequisite(user, "Manager")) {
            if (cardinality.canAssignRole(user)) {
                user.addRole(managerRole);
                System.out.println("✅ 角色分配成功");
            }
        }

        // 6. 测试基数约束：尝试分配第三个角色（应该失败）
        System.out.println("\n--- 测试4：尝试分配第三个角色(架构师) ---");
        if (prerequisite.checkPrerequisite(user, "Architect")) {
            if (cardinality.canAssignRole(user)) {
                user.addRole(architectRole);
            }
        }
    }
}
