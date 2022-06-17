package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.entity.Project;
import com.bezkoder.springjwt.entity.ProjectProduct;

@Repository
public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Integer> {

     List<ProjectProduct> findProjectProductByProject(Project project);
}
