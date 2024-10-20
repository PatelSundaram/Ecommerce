package com.sundaram.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sundaram.app.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
