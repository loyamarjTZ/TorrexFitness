package com.joseloya.torrexfitness.security;

import com.joseloya.torrexfitness.model.Customer;
import com.joseloya.torrexfitness.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //added
    @Autowired
    private CustomerRepository customerRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));

        Customer customer = new Customer();
        customer.setFirstName(registration.getFirstName());
        customer.setLastName(registration.getLastName());
        customer.setEmail(registration.getEmail());
        customer.setPassword(user.getPassword());
//        customer.setPassword(passwordEncoder.encode(registration.getPassword()));

        if(user.getFirstName().contains("superadmin")){
            user.setRoles(Arrays.asList(
                    new Role("ROLE_SUPERADMIN"),
                    new Role("ROLE_ADMIN"),
                    new Role("ROLE_USER")
            ));
        } else if(user.getFirstName().contains("admin")) {
            user.setRoles(Arrays.asList(
                    new Role("ROLE_ADMIN"),
                    new Role("ROLE_USER")
            ));
        } else {
            user.setRoles(Arrays.asList(
                    new Role("ROLE_USER")
            ));
        }

        customerRepository.save(customer);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}

