package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.user.model.UserRole;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Integer>{

}
