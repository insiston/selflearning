package com.ypm.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ypm.interfaces.IUserService;
import com.ypm.model.User;
import com.ypm.util.StringUtil;


public class CustomUserDetailsService  implements UserDetailsService{

	 @Autowired 
	 IUserService userService;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.getUserInfoByUserName(username);
		 if(user == null){
	            throw new UsernameNotFoundException("not found");
	        }
		 List<String> authoryList = StringUtil.getSeparatorList(user.getAuthorities(), null);
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	        for(String auth:authoryList){
	        	 authorities.add(new SimpleGrantedAuthority(auth));
	        }
	        System.err.println("username is " + username + ", auth is " + user.getAuthorities());
	        return new org.springframework.security.core.userdetails.User(user.getUsername(),
	                user.getPassword(), authorities);
		
	}

}
