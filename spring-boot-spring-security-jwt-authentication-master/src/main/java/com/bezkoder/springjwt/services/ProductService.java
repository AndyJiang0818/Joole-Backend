package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.entity.Manufacturer;
import com.bezkoder.springjwt.entity.Product;
import com.bezkoder.springjwt.entity.ProductType;
import com.bezkoder.springjwt.entity.Sale;
import com.bezkoder.springjwt.entity.TechnicalDetail;

import java.util.List;

public interface ProductService {
        public Product findOneById(Integer Id);

        public List<Product> findAll();

        public Product save(Product product);

        public boolean create(Product product, Manufacturer manufacturer,
                        TechnicalDetail technicalDetail,
                        ProductType productType,
                        Sale sale);

        public boolean delete(Product product);

        public boolean update(Product product);

        public Product get(Integer id);

        public boolean deleteAll();

        public List<Product> findProducesByProductType(String name);

        public TechnicalDetail findProductsTechnicalDetailBypProductId(Integer id);

        public Manufacturer findManufacturerByProductId(Integer id);

        public Sale findSaleByProductId(Integer id);

        public List<Product> findProductsByProductTypeAndTechnicalDetail(String name, TechnicalDetail technicalDetail);

        public List<Product> findProductsByProductTypeAndTechnicalDetailAndModelYearAndBrand(String name,
                        TechnicalDetail technicalDetail,
                        Integer modelYear,
                        String brand);

        public Product findProductByName(String name);
}
