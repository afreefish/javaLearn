package com.cdrcb.irc.brac.pojo;

import java.util.HashSet;
import java.util.Set;

// 用户类
public class User {
    private String username;
    private Set<Role> roles;

    public User(String username) {
        this.username = username;
        this.roles = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Set<Role> getRoles() {
        return new HashSet<>(roles); // 返回副本防止外部直接修改
    }

    public boolean hasRole(String roleName) {
        return roles.stream().anyMatch(r -> r.getName().equals(roleName));
    }
}
