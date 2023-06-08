package br.com.self_employed.models.Entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.self_employed.models.Enum.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_USER")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel implements UserDetails {

	private static final long serialVersionUID = 2107390232972474715L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String username;

	private String password;
	
	private String location;
	
	private String biography;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
			return password;
	}

	@Override
	public String getUsername() {
			return username;
	}

	@Override
	public boolean isAccountNonExpired() {
			return true;
	}

	@Override
	public boolean isAccountNonLocked() {
			return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
			return true;
	}

	@Override
	public boolean isEnabled() {
			return true;
	}

}
