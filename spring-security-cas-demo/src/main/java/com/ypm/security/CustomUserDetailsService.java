package com.ypm.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ypm.model.User;
import com.ypm.repository.UserRespository;


public class CustomUserDetailsService  implements UserDetailsService{

	 @Autowired 
	 UserRespository userRepository;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		 if(user == null){
	            throw new UsernameNotFoundException("not found");
	        }
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
	        System.err.println("username is " + username + ", " + user.getRole().name());
	        return new org.springframework.security.core.userdetails.User(user.getUsername(),
	                user.getPassword(), authorities);
		
	}

}