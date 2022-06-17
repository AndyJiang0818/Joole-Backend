package com.bezkoder.springjwt.services;

import java.util.List;

import com.bezkoder.springjwt.entity.ProductType;

public interface ProductTypeService {

    public ProductType findOneById(Integer Id);

    public List<ProductType> findAll();

    public ProductType save(ProductType productType);

    public ProductType findByName(String name);

    public boolean create(ProductType productType);

    public boolean delete(ProductType productType);

    public ProductType get(Integer id);

    public boolean update(ProductType productType);

}
