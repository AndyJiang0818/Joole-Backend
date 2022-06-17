package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.entity.Product;
import com.bezkoder.springjwt.entity.ProductType;
import com.bezkoder.springjwt.entity.TechnicalDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
        public List<Product> findProductsByProductType(ProductType productType);

        public List<Product> findProductsByProductTypeAndTechnicalDetail(ProductType productType,
                        TechnicalDetail technicalDetail);

        public List<Product> findProductsByProductTypeAndTechnicalDetailAndModelYearAndBrand(ProductType productType,
                        TechnicalDetail technicalDetail,
                        Integer modelYear,
                        String brand);

        public Product findProductByName(String name);

}
