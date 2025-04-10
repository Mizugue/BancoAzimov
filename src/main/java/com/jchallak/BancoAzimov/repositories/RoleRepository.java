package com.jchallak.BancoAzimov.repositories;

import com.jchallak.BancoAzimov.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
