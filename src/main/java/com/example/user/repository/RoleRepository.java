package com.example.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.user.model.UserRole;

public interface RoleRepository extends CrudRepository<UserRole, Integer>{

}
