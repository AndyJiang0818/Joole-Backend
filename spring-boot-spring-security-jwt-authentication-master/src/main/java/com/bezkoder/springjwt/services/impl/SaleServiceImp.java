package com.bezkoder.springjwt.services.impl;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SaleServiceImp implements SaleService{
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale findOneById(Integer Id){
        return saleRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Sale> findAll(){
        return saleRepository.findAll();
    }

    @Override
    public Sale save(Sale sale){
        return saleRepository.save(sale);
    }
}
