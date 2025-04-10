package com.jchallak.BancoAzimov.repositories;

import com.jchallak.BancoAzimov.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
