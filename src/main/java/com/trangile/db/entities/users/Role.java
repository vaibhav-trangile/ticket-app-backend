package com.trangile.db.entities.users;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLEID")
	private Long roleId;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name; // Role name (e.g., "ROLE_USER", "ROLE_ADMIN")

	@Column(name = "DESCRIPTION")
	private String description;
	
//	@ManyToMany(mappedBy = "roles")
//	private Set<User> users;

	public Role() {
		
	}

	public Role(Long roleId, String name, String description) {
		this.roleId = roleId;
		this.name = name;
		this.description = description;
//		this.users = users;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public int hashCode() {
		return Objects.hash(description, name, roleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(roleId, other.roleId);
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + ", description=" + description + "]";
	}
}