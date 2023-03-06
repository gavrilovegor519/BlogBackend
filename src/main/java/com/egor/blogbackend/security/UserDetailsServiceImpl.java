package com.egor.blogbackend.security;

import com.egor.blogbackend.entities.Users;
import com.egor.blogbackend.repos.UsersRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UsersRepository repository;

    public UserDetailsServiceImpl(UsersRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = repository.findByUsername(username);

        if (users == null) {
            throw new UsernameNotFoundException("This user is not found");
        }

        return new User(users.getUsername(), users.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
