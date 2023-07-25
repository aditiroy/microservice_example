package com.channel4.mint.automated.spot.application.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.channel4.mint.securitycomponent.model.MintAuthenticatedUser;

/**
 * This class is the Utility class for Domain Layer.
 * 
 * This class acts as the utility for Service and Repository classes to map
 * values from DB entities to DTO classes and vice versa. Also contains helping
 * methods to perform conversions.
 * 
 * @author HCL 
 */
@Component
public class SecurityUtil {
	/**
	 * This method is used to get roles
	 * 
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public List<String> getRoles() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MintAuthenticatedUser au = (MintAuthenticatedUser) auth.getPrincipal();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) au.getAuthorities();
		List<String> authRoleList = new ArrayList<>();
		authorities.stream().forEach(authority -> authRoleList.add(authority.getAuthority()));

		return authRoleList;
	}

	/**
	 * This method is used to get the loggedin user
	 * 
	 * @return String
	 */
	public String getLoginUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MintAuthenticatedUser au = (MintAuthenticatedUser) auth.getPrincipal();
		return au.getUsername();
	}

}