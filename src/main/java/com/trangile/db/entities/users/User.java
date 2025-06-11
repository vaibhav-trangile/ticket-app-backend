package com.trangile.db.entities.users;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USERS", uniqueConstraints = { 
	      @UniqueConstraint(columnNames = "username"),
	      @UniqueConstraint(columnNames = "email") 
	    })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private long userId;

    @Column(name = "USERNAME") // Fixed typo
    private String userName;

    @Column(name = "FULLNAME", nullable = false)
    private String fullName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @Column(name = "ISEMAILVERIFIED")
    private Boolean isEmailVerified;

    @Column(name = "ISLOCK")
    private Boolean isLocked;

    @Column(name = "LASTLOGIN")
    private LocalDateTime lastLogin;

    @Column(name = "FAILEDLOGINATTEMPTS")
    private int failedLoginAttempts;

    @Column(name = "PASSWORDRESETTOKEN")
    private String passwordResetToken;

    @Column(name = "TOKENEXPIRYDATE")
    private LocalDateTime tokenExpiryDate;

    @Column(name = "PASSWORDLASTCHANGED")
    private LocalDateTime passwordLastChanged;

    @CreationTimestamp
    @Column(name = "CREATEDON", updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @Column(name = "UPDATEDON", nullable = false)
    private LocalDateTime updatedOn;

    @Column(name = "CREATEDBY")
    private String createdBy;

    @Column(name = "UPDATEDBY")
    private String updatedBy;

//    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(name = "USERROLES", joinColumns = @JoinColumn(name = "USERID"), inverseJoinColumns = @JoinColumn(name = "ROLEID"))
//    private Set<Role> roles = new HashSet<>(); // Default initialization
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
          joinColumns = @JoinColumn(name = "user_id"), 
          inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    
	public User() {
		
	}

	public User(long userId, String userName, String fullName, String email, String password, Boolean isActive,
			Boolean isEmailVerified, Boolean isLocked, LocalDateTime lastLogin, int failedLoginAttempts,
			String passwordResetToken, LocalDateTime tokenExpiryDate, LocalDateTime passwordLastChanged,
			LocalDateTime createdOn, LocalDateTime updatedOn, String createdBy, String updatedBy, Set<Role> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.isEmailVerified = isEmailVerified;
		this.isLocked = isLocked;
		this.lastLogin = lastLogin;
		this.failedLoginAttempts = failedLoginAttempts;
		this.passwordResetToken = passwordResetToken;
		this.tokenExpiryDate = tokenExpiryDate;
		this.passwordLastChanged = passwordLastChanged;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.roles = roles;
	}

	public User(String userName, String fullName, String email) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdOn, email, failedLoginAttempts, fullName, isActive, isEmailVerified,
				isLocked, lastLogin, password, passwordLastChanged, passwordResetToken, roles, tokenExpiryDate,
				updatedBy, updatedOn, userId, userName);
	}
	
	
	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(Boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public String getPasswordResetToken() {
		return passwordResetToken;
	}

	public void setPasswordResetToken(String passwordResetToken) {
		this.passwordResetToken = passwordResetToken;
	}

	public LocalDateTime getTokenExpiryDate() {
		return tokenExpiryDate;
	}

	public void setTokenExpiryDate(LocalDateTime tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}

	public LocalDateTime getPasswordLastChanged() {
		return passwordLastChanged;
	}

	public void setPasswordLastChanged(LocalDateTime passwordLastChanged) {
		this.passwordLastChanged = passwordLastChanged;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(email, other.email) && failedLoginAttempts == other.failedLoginAttempts
				&& Objects.equals(fullName, other.fullName) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isEmailVerified, other.isEmailVerified) && Objects.equals(isLocked, other.isLocked)
				&& Objects.equals(lastLogin, other.lastLogin) && Objects.equals(password, other.password)
				&& Objects.equals(passwordLastChanged, other.passwordLastChanged)
				&& Objects.equals(passwordResetToken, other.passwordResetToken) && Objects.equals(roles, other.roles)
				&& Objects.equals(tokenExpiryDate, other.tokenExpiryDate) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(updatedOn, other.updatedOn) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + ", isEmailVerified=" + isEmailVerified
				+ ", isLocked=" + isLocked + ", lastLogin=" + lastLogin + ", failedLoginAttempts=" + failedLoginAttempts
				+ ", passwordResetToken=" + passwordResetToken + ", tokenExpiryDate=" + tokenExpiryDate
				+ ", passwordLastChanged=" + passwordLastChanged + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", roles=" + roles + "]";
	}


}
