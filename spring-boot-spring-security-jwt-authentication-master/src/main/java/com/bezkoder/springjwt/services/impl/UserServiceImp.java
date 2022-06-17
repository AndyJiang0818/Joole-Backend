package com.bezkoder.springjwt.services.impl;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createUser(String username, String password, String email) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);

        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role(ERole.ROLE_USER));

        user.setRoles(roles);

        try {
            repository.save(user);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean delete(String password, int id) {

        User target = findUserById(id);

        if (target == null || !target.getPassword().equals(password)) {
            return false;
        } else {

            try {
                repository.deleteById((long) id);
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                e.printStackTrace();
                return false;
            }

            return true;
        }

    }

    public User findUserById(long id) {
        return repository.findById(id).orElse(null);

    }

    // return true if user password and username exists, else false
    public boolean userLogin(String username, String password) {

        User target = repository.findUserByUsername(username);

        if (target == null || !target.getPassword().equals(password) || !target.getUsername().equals(username)) {
            return false;
        } else {

            try {
                System.out.println(
                        "\nUser Login: " + target.getUsername() + " " + target.getPassword() + " was successful");
            } catch (Exception e) {
                System.out.println("" + e.getMessage());
                e.printStackTrace();
                return false;
            }

            return true;
        }

    }

    public boolean updateUser(User user) {

        try {
            repository.save(user);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;

    }

    // Return System.out.println saying the user was logged out successfully
    public boolean userLogout() {

        try {
            System.out.println("\nUser Logged out");
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean addProject(Project project, User user) {
        try {
            project.setUser(user);
            repository.save(user);
            projectRepository.save(project);
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
