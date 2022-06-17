package com.bezkoder.springjwt.services.impl;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.repository.*;
import com.bezkoder.springjwt.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TechnicalDetailServiceImp implements  TechnicalDetailService{

    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public TechnicalDetail findOneById(Integer Id){
        return technicalDetailRepository.findById(Id).orElse(null);
    }

    @Override
    public List<TechnicalDetail> findAll(){
        return technicalDetailRepository.findAll();
    }

    @Override
    public TechnicalDetail save(TechnicalDetail technicalDetail){
        return technicalDetailRepository.save(technicalDetail);
    }

    @Override
    public List<TechnicalDetail> getTechnicalDetailByName(String name){
        //name is productType name
        ProductType productType = productTypeRepository.getProductTypeByProductTypeDetail(name);
        return technicalDetailRepository.getTechnicalDetailByProductType(productType);
    }
}
