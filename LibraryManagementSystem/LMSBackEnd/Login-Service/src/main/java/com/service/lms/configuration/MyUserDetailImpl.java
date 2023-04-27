package com.service.lms.configuration;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.service.lms.entity.ERole;
import com.service.lms.entity.Role;
import com.service.lms.entity.User;

public class MyUserDetailImpl 
//implements UserDetails
{
	
//	private static final long serialVersionUID = 1L;
//	
//	private String userName;
//	private String password;
//	private boolean isActive;
//	private boolean isCredentialsNonExpired;
//	private boolean isAccountNonExpired;
//	private boolean isAccountNonLocked;
//	private List<GrantedAuthority> authorities;
//	
//	public MyUserDetailImpl(User user) {
//		this.userName = user.getUserName();
//		this.password = user.getPassword();
//		this.isActive = user.isActive();
//		this.authorities = Arrays.stream(user.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//		this.isAccountNonExpired=true;
//		this.isAccountNonLocked=true;
//		this.isCredentialsNonExpired=true;
//	}
//
//	public MyUserDetailImpl() {}
//
//
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {
//
//		return userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return isActive;
//	}

}
