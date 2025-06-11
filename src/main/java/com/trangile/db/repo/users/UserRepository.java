package com.trangile.db.repo.users;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trangile.db.entities.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
	
	@Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.userName = :name OR u.email = :name")
	Optional<User> findByUserNameOrEmail(@Param("name") String name);
	
	
	Optional<User> findByUserName(String username);
    
	Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name = :roleName")
    List<User> findUsersByRole(@Param("roleName") String roleName);
}