package com.shopping_cart.eshoppers.service;

import com.shopping_cart.eshoppers.entity.Role;
import com.shopping_cart.eshoppers.entity.User;
import com.shopping_cart.eshoppers.dto.UserDTO;
import com.shopping_cart.eshoppers.repository.RoleRepository;
import com.shopping_cart.eshoppers.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 ** 2024, July 16, Tuesday, 3:49 PM
 */

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setRoleList(List.of(new Role("ROLE_USER")));

        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByUserName(username);
        if(existingUser!=null)
            return new org.springframework.security.core.userdetails.User(
                    existingUser.getUserName(),
                    existingUser.getPassword(),
                    getAuthorities(existingUser.getRoleList())
            );
        else
            throw new UsernameNotFoundException("Invalid username or password.");
    }

    private List<GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : roles)
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        return grantedAuthorities;
    }
}
