package com.umishra.TaskManager.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.umishra.TaskManager.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	Optional<Users> findByUsername(String username);
}