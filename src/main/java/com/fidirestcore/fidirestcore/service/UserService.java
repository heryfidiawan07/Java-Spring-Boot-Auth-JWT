package com.fidirestcore.fidirestcore.service;

import java.util.List;

import com.fidirestcore.fidirestcore.entity.RoleEntity;
import com.fidirestcore.fidirestcore.entity.UserEntity;

public interface UserService {
    UserEntity saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String username, String roleName);
    UserEntity getUser(String username);
    List<UserEntity>getUsers();
}
