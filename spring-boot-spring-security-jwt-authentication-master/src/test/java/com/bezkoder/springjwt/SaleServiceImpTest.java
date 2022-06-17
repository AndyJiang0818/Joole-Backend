package com.bezkoder.springjwt;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.services.impl.SaleServiceImp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceImpTest {

    @Autowired
    private SaleServiceImp saleService;

    private Sale sale = new Sale();

    @Test
    void findOneById() {

        int id = 1;
        // sale.setId(id);
        //
        // Sale expected = sale;

        Sale actual = saleService.findOneById(id);
        Assert.assertTrue(actual != null);
        // Assert.assertEquals(expected, actual);
    }

    @Test
    void findAll() {

        // List<Sale> expected = new ArrayList<>();
        // expected.add(sale);

        List<Sale> actual = saleService.findAll();
        Assert.assertTrue(actual != null);
        // Assert.assertEquals(expected, actual);
    }

    @Test
    void save() {
        Sale actual = saleService.save(sale);
        Assert.assertTrue(actual != null);
    }
}