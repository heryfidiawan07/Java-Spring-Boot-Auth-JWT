package com.fidirestcore.fidirestcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fidirestcore.fidirestcore.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
