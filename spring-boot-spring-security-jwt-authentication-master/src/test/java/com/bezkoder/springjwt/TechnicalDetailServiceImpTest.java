package com.bezkoder.springjwt;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.services.impl.TechnicalDetailServiceImp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class TechnicalDetailServiceImpTest {

    @Autowired
    private TechnicalDetailServiceImp technicalService;


    private TechnicalDetail technicalDetail = new TechnicalDetail();


    @Test
    void findOneById() {

        int id = 1;
//        technicalDetail.setId(id);
//        TechnicalDetail expected = technicalDetail;

        TechnicalDetail actual = technicalService.findOneById(id);
        Assert.assertTrue(actual != null);
//        Assert.assertEquals(expected, actual);
    }

    @Test
    void findAll() {
        List<TechnicalDetail> actual = technicalService.findAll();

        Assert.assertTrue(actual != null);
    }

    @Test
    void save() {

//        TechnicalDetail expected = technicalDetail;

        TechnicalDetail actual = technicalService.save(technicalDetail);

        Assert.assertTrue(actual != null);
    }

    @Test
    void getTechnicalDetailByName() {

        String test = "airflow";

        List<TechnicalDetail> expected = new ArrayList<>();
        TechnicalDetail t1 = technicalService.findOneById(1);
        TechnicalDetail t2 = technicalService.findOneById(5);
        expected.add(t1);
        expected.add(t2);

        List<TechnicalDetail> actual = technicalService.getTechnicalDetailByName(test);
        Assert.assertTrue(actual != null);
//        Assert.assertEquals(expected, actual);


    }
}