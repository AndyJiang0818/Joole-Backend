package com.bezkoder.springjwt.services;

import java.util.List;

import com.bezkoder.springjwt.entity.TechnicalDetail;

public interface TechnicalDetailService {
    public TechnicalDetail findOneById(Integer Id);

    public List<TechnicalDetail> findAll();

    public TechnicalDetail save(TechnicalDetail technicalDetail);

    public List<TechnicalDetail> getTechnicalDetailByName(String name);

}
