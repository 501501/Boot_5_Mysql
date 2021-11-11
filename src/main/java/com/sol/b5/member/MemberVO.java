package com.sol.b5.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {
	@NotBlank
	private String id; // 비어있으면 X
	@Size(min = 6, max = 12)
	private String pw; // 6글자 이상 12글자 이하
	private String pwCheck;
	@NotBlank
	private String name; // 비어있으면 X
	@NotBlank
	@Email
	private String email; // email 형식
	@NotNull
	@Range(min = 0, max = 150)
	private Integer age; // 0 ~ 150
	@Past
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date birth; // 생년월일 현재보다 과거여야 함
	private String role;
	private boolean enabled;
	
	private MemberFilesVO memberFilesVO;
	private List<RoleVO> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleVO roleVO:roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pw;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	
}
