package com.umishra.TaskManager.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.umishra.TaskManager.DAO.UsersRepository;
import com.umishra.TaskManager.entity.Role;
import com.umishra.TaskManager.entity.Users;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
	
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Users> optionalUser = usersRepository.findByUsername(userName);
        if(optionalUser.isPresent()) {
        	Users users = optionalUser.get();
        	
        	List<String> roleList = new ArrayList<String>();
        	for(Role role:users.getRoles()) {
        		roleList.add(role.getRoleName());
        	}
        	
            return User.builder()
            	.username(users.getUsername())
            	//change here to store encoded password in db
            	.password( bCryptPasswordEncoder.encode(users.getPassword()) )
            	.disabled(users.isDisabled())
            	.accountExpired(users.isAccountExpired())
            	.accountLocked(users.isAccountLocked())
            	.credentialsExpired(users.isCredentialsExpired())
            	.roles(roleList.toArray(new String[0]))
            	.build();
        } else {
        	throw new UsernameNotFoundException("User Name is not Found");
        }   
    }
    
    
}