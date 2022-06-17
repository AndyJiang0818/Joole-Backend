package com.bezkoder.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "product_type_detail", length = 50)
    private String productTypeDetail;

    @Column(name = "create_time", length = 50)
    private Timestamp createTime;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.REMOVE, mappedBy = "productType")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = TechnicalDetail.class, cascade = CascadeType.REMOVE, mappedBy = "productType")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TechnicalDetail> technicalDetails = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        if (products.contains(product)) {
            return;
        }
        products.add(product);
        product.setProductType(this);
    }

    public void removeProducts(Product product) {
        if (!products.contains(product)) {
            return;
        }
        products.remove(product);
        product.setProductType(null);
    }

    // next
    public List<TechnicalDetail> getTechnicalDetails() {
        return technicalDetails;
    }

    public void addTechnicalDetails(TechnicalDetail technicalDetail) {
        if (technicalDetails.contains(technicalDetail)) {
            return;
        }
        technicalDetails.add(technicalDetail);
        technicalDetail.setProductType(this);
    }

    public void removeTechnicalDetails(TechnicalDetail technicalDetail) {
        if (!technicalDetails.contains(technicalDetail)) {
            return;
        }
        technicalDetails.remove(technicalDetail);
        technicalDetail.setProductType(null);
    }

    @Override
    public String toString() {
        return "ProductType{" + "id=" + id + "}";
    }

    public String toJson(List<String> entries) {
        String result = null;
        List<String> colsContent = new ArrayList<>();
        for (String entry : entries) {
            colsContent.add(entry);
        }
        result = "{" + String.join(",", colsContent) + "}";
        return String.format("{\"ProductTypeId\" : \"%d\", \"content\" : \"%s\"}", getId(), result);

    }

    public ProductType() {
    }

    public ProductType(String productTypeDetail, Timestamp createTime) {
        this.productTypeDetail = productTypeDetail;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getProductTypeDetail() {
        return productTypeDetail;
    }

    public void setProductTypeDetail(String productTypeDetail) {
        this.productTypeDetail = productTypeDetail;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
