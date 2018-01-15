package com.db.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.dbservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String userName);
}
