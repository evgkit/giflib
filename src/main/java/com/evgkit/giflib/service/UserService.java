package com.evgkit.giflib.service;

import com.evgkit.giflib.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
