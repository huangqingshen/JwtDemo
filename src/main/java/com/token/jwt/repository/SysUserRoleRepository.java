package com.token.jwt.repository;


import com.token.jwt.domain.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long> {
    SysUserRole getMenusByRoleName(String name);

    SysUserRole findByRoleName(String role);
}
