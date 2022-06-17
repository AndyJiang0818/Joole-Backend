package com.bezkoder.springjwt.services;

import java.util.Collection;

import com.bezkoder.springjwt.entity.Project;
import com.bezkoder.springjwt.entity.User;

public interface ProjectService {
    public Project findOneById(Integer Id);

    public Collection<Project> findAll();

    public Project save(Project project);

    public boolean create(Project project, User user);

    public boolean delete(Project project);

    public boolean update(Project project);

    public boolean deleteAll();

    public Project get(Integer id);
}
