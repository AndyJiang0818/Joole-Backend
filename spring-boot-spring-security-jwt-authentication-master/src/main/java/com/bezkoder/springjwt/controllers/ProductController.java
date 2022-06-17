package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private TechnicalDetailService technicalDetailService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private SaleService saleService;

    @GetMapping("/getProductType")
    public ResponseEntity<?> getAllProductType() {
        List<ProductType> productTypesList = productTypeService.findAll();

        return new ResponseEntity<>(productTypesList, HttpStatus.OK);
    }

    @GetMapping("/getAllProductFromProductType")
    public ResponseEntity<?> getAllProductFromProductType(@RequestParam("ProductType") String productTypeName) {
        List<Product> productList = productService.findProducesByProductType(productTypeName);

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/getProductInfo")
    public ResponseEntity<?> getProductById(@RequestParam("ProductId") Integer productId) {
        Product product = productService.get(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestParam("Productname") String name,
            @RequestParam("model_year") Integer modelYear,
            @RequestParam("brand") String brand,
            @RequestParam("product_type_id") Integer productTypeId,
            @RequestParam("technical_detail_id") Integer technicalDetailId,
            @RequestParam("manufacturer_detail_id") Integer manufacturerDetailId,
            @RequestParam("sale_id") Integer saleId) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        Product product = new Product(name, modelYear, brand, createTime, updateTime);
        ProductType productType = productTypeService.findOneById(productTypeId);
        TechnicalDetail technicalDetail = technicalDetailService.findOneById(technicalDetailId);
        Manufacturer manufacturer = manufacturerService.findOneById(manufacturerDetailId);
        Sale sale = saleService.findOneById(saleId);
        boolean result = productService.create(product, manufacturer, technicalDetail, productType, sale);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@RequestParam("ProductId") Integer productId,
            @RequestParam("model_year") Integer modelYear,
            @RequestParam("brand") String brand) {
        Product product = productService.get(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (modelYear != null) {
            product.setModelYear(modelYear);
        }
        if (brand != null) {
            product.setBrand(brand);
        }
        product.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        boolean result = productService.update(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/deleteProductByProductId")
    public ResponseEntity<?> deleteProductById(@RequestParam("ProductId") Integer productId) {
        Product product = productService.get(productId);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean result = productService.delete(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getProductTechnicalDetailById")
    public ResponseEntity<?> getProductTechnicalDetailById(@RequestParam("ProductId") Integer productId) {
        TechnicalDetail result = productService.findProductsTechnicalDetailBypProductId(productId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/getManufacturerByProductId")
    public ResponseEntity<?> getProductManufacturerById(@RequestParam("ProductId") Integer productId) {
        Manufacturer result = productService.findManufacturerByProductId(productId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/getSaleByProductId")
    public ResponseEntity<?> getProductSaleById(@RequestParam("ProductId") Integer productId) {
        Sale result = productService.findSaleByProductId(productId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllProductFromProductTypeAndTechnicalDetailAndModelYearAndBrand")
    public ResponseEntity<?> getAllProductFromProductTypeAndTechnicalDetailAndModelYearAndBrand(
            @RequestParam("name") String name,
            @RequestParam("techicalDetailId") Integer technicalDetailId,
            @RequestParam("modelYear") Integer modelYear,
            @RequestParam("brand") String brand) {
        TechnicalDetail technicalDetail = technicalDetailService.findOneById(technicalDetailId);
        List<Product> result = productService.findProductsByProductTypeAndTechnicalDetailAndModelYearAndBrand(name,
                technicalDetail, modelYear, brand);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping("/findProductByName")
    public ResponseEntity<?> findProductByName(@RequestParam("name") String name) {

        Product result = productService.findProductByName(name);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/findAllProducts")
    public ResponseEntity<?> findAllProducts() {
        List<Product> result = productService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
