package fr.orsys.kingsley.ecommerce.business;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String profileImageUrl;
	private LocalDate lastLoginDate;
	private LocalDate lastLoginDateDisplay;
	private LocalDate joinDate;
	//private String[] roles; //ROLE_USER{read, edit}, ROLE_ADMIN {delete}
	private String role;
	//private String[] authorities;
	private boolean isActive;
	private boolean isNotLocked;
}
