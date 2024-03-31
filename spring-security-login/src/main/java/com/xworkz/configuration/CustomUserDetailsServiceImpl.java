package com.xworkz.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.xworkz.entity.User;
import com.xworkz.repository.UserRepository;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = repository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		return new CustomUserDetails(user);
	}

}
