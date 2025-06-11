package com.trangile.db.repo.users;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trangile.db.entities.users.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {
	
	Role findByName(String roleName);

}
