package com.laxman.shopsphere.security;

import com.laxman.shopsphere.user.entity.User;
import com.laxman.shopsphere.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User Not found with email: "+ username
                ));

        return  new CustomUserDetails(user);
    }
}