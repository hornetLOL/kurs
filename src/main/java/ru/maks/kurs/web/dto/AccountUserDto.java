package ru.maks.kurs.web.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.maks.kurs.entity.Staff;
import ru.maks.kurs.entity.enums.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountUserDto {

//	private Long id;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

//	@NotBlank
//	private UserRole role;
//
//	private StaffDto userData;
//
//
//	@Builder.Default
//	private boolean accountNonExpired = true;
//
//	@Builder.Default
//	private boolean accountNonLocked = true;
//
//	@Builder.Default
//	private boolean credentialsNonExpired = true;
//
//	@Builder.Default
//	private boolean enabled = true;
//
//
//	public Set<GrantedAuthority> getAuthorities() {
//		return new HashSet<>(mapRolesToAuthorities(this.role));
//
//	}
//
//
//	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(UserRole role) {
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(role.getTitle()));
//		return  authorities;
////				roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//	}
}
