package com.kamal.schoolerp.schoolerp.services.user;

import com.kamal.schoolerp.schoolerp.entities.Role;
import com.kamal.schoolerp.schoolerp.entities.User;
import com.kamal.schoolerp.schoolerp.repositories.RoleRepository;
import com.kamal.schoolerp.schoolerp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role role = roleRepository.findByRoleName("ADMIN_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
    }
}
