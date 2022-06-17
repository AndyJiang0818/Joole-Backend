package com.bezkoder.springjwt.services;

import java.util.Collection;

import com.bezkoder.springjwt.entity.Product;
import com.bezkoder.springjwt.entity.Project;
import com.bezkoder.springjwt.entity.ProjectProduct;

public interface ProjectProductService {

    public Collection<ProjectProduct> findAll();

    public ProjectProduct findById(Integer Id);

    public boolean create(ProjectProduct projectProduct, Project project, Product product);

    public boolean delete(ProjectProduct projectProduct);

    public boolean update(ProjectProduct projectProduct);

    public ProjectProduct get(Integer id);

}
