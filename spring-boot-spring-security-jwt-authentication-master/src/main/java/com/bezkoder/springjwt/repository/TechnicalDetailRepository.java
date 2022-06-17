package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.entity.ProductType;
import com.bezkoder.springjwt.entity.TechnicalDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalDetailRepository extends JpaRepository<TechnicalDetail, Integer> {

    public TechnicalDetail getTechnicalDetailByTechnicalDetailName(String name);

    public List<TechnicalDetail> getTechnicalDetailByProductType(ProductType productType);

    public TechnicalDetail getTechnicalDetailById(Integer id);
}
