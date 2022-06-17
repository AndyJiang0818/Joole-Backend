package com.bezkoder.springjwt;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.services.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProjectServiceImpTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private ProductType productType = new ProductType();

    @Test
    void findAll() {
        Collection<Project> actual = projectService.findAll();
        Assert.assertTrue(actual != null);
    }

    @Test
    void save() {
        Project project = new Project();
        Project actual = projectService.save(project);
        Assert.assertEquals(project, actual);
    }

    @Test
    void update() {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        // Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        User user = new User();
        Project project = new Project(10, null, null, null);
        boolean result = projectService.update(project);
        Assert.assertTrue(result);
    }

}
