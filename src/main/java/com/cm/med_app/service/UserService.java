package com.cm.med_app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cm.med_app.model.User;
import com.cm.med_app.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	
	public List<User> getAllUSers()
	{
		return userRepo.findAll();
	}
	
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findByUserName(String name)
	{
		return userRepo.findByUserName(name).orElseThrow(()->new UsernameNotFoundException("user name not found"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepo.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("user name not found"));
		var authorities=user.getRoles().stream().map(role->new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),true,true,true,true,authorities);
	}

}
