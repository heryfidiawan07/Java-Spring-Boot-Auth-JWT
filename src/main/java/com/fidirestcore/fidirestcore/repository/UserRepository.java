package com.fidirestcore.fidirestcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fidirestcore.fidirestcore.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
