package com.cdrcb.irc.brac.pojo;

// 角色类
public class Role {
    private String name;
    public Role(String name) { this.name = name; }
    public String getName() { return name; }
    @Override
    public String toString() { return "Role{name='" + name + "'}"; }
}