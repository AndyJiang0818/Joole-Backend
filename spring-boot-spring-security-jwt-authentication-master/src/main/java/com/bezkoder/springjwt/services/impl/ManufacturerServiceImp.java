package com.bezkoder.springjwt.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.entity.Manufacturer;
import com.bezkoder.springjwt.repository.ManufacturerRepository;
import com.bezkoder.springjwt.services.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImp implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer findOneById(Integer Id) {
        return manufacturerRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}
