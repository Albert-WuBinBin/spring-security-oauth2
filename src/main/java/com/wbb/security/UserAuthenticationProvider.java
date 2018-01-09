package com.wbb.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;



public class UserAuthenticationProvider implements AuthenticationProvider {

	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String loginName = authentication.getName();
	        if ("admin".equals(loginName)&&"123456".equals(authentication.getCredentials().toString())) {
	            //Collection userAuthorities = new HashSet();
	            ArrayList<GrantedAuthority> userAuthorities = new ArrayList<GrantedAuthority>();  
	            userAuthorities.add(new SimpleGrantedAuthority("ROLE_APP"));
	            return new UsernamePasswordAuthenticationToken(loginName, authentication.getCredentials(), userAuthorities);
	        } else {
	            throw new BadCredentialsException("Invalid account");
	        }
	    }

	    public boolean supports(Class<?> aClass) {
	        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
	    }

}
