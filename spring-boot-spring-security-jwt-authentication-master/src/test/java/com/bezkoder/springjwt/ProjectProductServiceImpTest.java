package com.bezkoder.springjwt;

import java.sql.Timestamp;
import java.util.List;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.impl.ProjectProductServiceImp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectProductServiceImpTest {

    @Autowired
    private ProjectProductServiceImp projectProductService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Test
    void findAll() {
        List<ProjectProduct> list = projectProductService.findAll();
        Assert.assertTrue(list != null);

    }

    @Test
    void create() {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        ProjectProduct projectProduct = new ProjectProduct(time);

        Product product = new Product("Test1", 2022, "Meta", time, time);

        User user = new User();
        Project project = new Project(1, null, time, time);

        System.out.println("\n\n ProjectProduct Object: " + projectProduct.toString());

        projectProductService.create(projectProduct, project, product);
        Assert.assertTrue(projectProductService != null);
    }

    @Test
    void update() {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        ProjectProduct projectProduct = new ProjectProduct(time);
        boolean result = projectProductService.update(projectProduct);
        Assert.assertTrue(result);

    }

}
