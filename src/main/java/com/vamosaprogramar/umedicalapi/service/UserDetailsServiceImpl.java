package com.vamosaprogramar.umedicalapi.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   
	private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userService.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
      
  
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
