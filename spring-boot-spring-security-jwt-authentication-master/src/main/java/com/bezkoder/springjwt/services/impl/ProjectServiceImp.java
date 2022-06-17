package com.bezkoder.springjwt.services.impl;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public Project findOneById(Integer Id){
        return projectRepository.findById(Id).orElse(null);
    }

    @Override
    public Collection<Project> findAll(){
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public boolean create(Project project, User user) {
        if (project == null || user == null) {
            System.out.println("Null input");
            return false;
        }
        Project target = findOneById(project.getId());
        if (target != null) {
            System.out.println("Project already exists");
        }

        try {
            project.setUser(user);
            userRepository.save(user);
            projectRepository.save(project);

        } catch (Exception e){
            System.out.println("something wrong happens when creating" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Project project) {
        if (project == null) {
            System.out.println("input is null");
            return false;
        }
        try{
            projectRepository.delete(project);
        }catch (Exception e){
            System.out.println("something wrong happens when creating" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Project project) {
        if (project == null) {
            System.out.println("input is null");
            return false;
        }
        try {
            projectRepository.save(project);
        } catch (Exception e) {
            System.out.println("something wrong happens when updating" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAll(){
        try{
            projectRepository.deleteAll();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;


    }

    @Override
    public Project get(Integer id) {
        if (id == null) {
            return null;
        }
        Optional<Project> result = projectRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else{
            return null;
        }
    }
}
