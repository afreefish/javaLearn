package com.cdrcb.irc.brac.utils;

import com.cdrcb.irc.brac.pojo.User;

/**
 * 1、基数约束示例
 * 基数约束主要限制数量。这里演示如何限制一个用户最多只能拥有 N 个角色。
 */
public class CardinalityConstraint {
    private final int maxRolesPerUser;

    public CardinalityConstraint(int maxRolesPerUser) {
        this.maxRolesPerUser = maxRolesPerUser;
    }

    /**
     * 校验是否可以给用户分配新角色
     */
    public boolean canAssignRole(User user) {
        if (user.getRoles().size() >= maxRolesPerUser) {
            System.out.println("❌ 基数约束违规：用户 " + user.getUsername() +
                    " 已达到最大角色数限制 (" + maxRolesPerUser + ")");
            return false;
        }
        return true;
    }
}
