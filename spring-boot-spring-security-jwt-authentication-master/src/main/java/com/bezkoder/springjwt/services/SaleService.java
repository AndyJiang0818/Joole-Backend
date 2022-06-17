package com.bezkoder.springjwt.services;

import java.util.List;

import com.bezkoder.springjwt.entity.Sale;

public interface SaleService {
    public Sale findOneById(Integer Id);

    public List<Sale> findAll();

    public Sale save(Sale sale);
}
