package com.bezkoder.springjwt.services;

import java.util.List;

import com.bezkoder.springjwt.entity.Manufacturer;

public interface ManufacturerService {
    public Manufacturer findOneById(Integer Id);

    public List<Manufacturer> findAll();

    public Manufacturer save(Manufacturer manufacturer);
}
