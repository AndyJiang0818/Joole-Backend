package com.bezkoder.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "technical_detail")
public class TechnicalDetail {

    @Id
    @GeneratedValue
    private Integer id;

    // @Column(name = "product_type_id", length = 20)
    // private Integer productTypeId;

    @ManyToOne(targetEntity = ProductType.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @Column(name = "technical_detail_name", length = 20)
    private String technicalDetailName;

    @Column(name = "technical_detail_number", length = 20)
    private Integer technicalDetailNumber;

    // @Column(name = "techninal_detail_comment", length = 20)
    // private String techninalDetailComment;

    @CreatedDate
    @Column(name = "create_time", length = 20)
    private Timestamp createTime;

    @Column(name = "update_time", length = 20)
    private Timestamp updateTime;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.REMOVE, mappedBy = "technicalDetail")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        if (products.contains(product)) {
            return;
        }
        products.add(product);
        product.setTechnicalDetail(this);
    }

    public void removeProducts(Product product) {
        if (!products.contains(product)) {
            return;
        }
        products.remove(product);
        product.setTechnicalDetail(null);
    }

    @Override
    public String toString() {
        return "TechnicalDetail{" + "id=" + id + "}";
    }

    public String toJson(List<String> entries) {
        String result = null;
        List<String> colsContent = new ArrayList<>();
        for (String entry : entries) {
            colsContent.add(entry);
        }
        result = "{" + String.join(",", colsContent) + "}";
        return String.format("{\"TechnicalDetailId\" : \"%d\", \"content\" : \"%s\"}", getId(), result);

    }

    public TechnicalDetail() {
    }

    public TechnicalDetail(String technicalDetailName, Integer technicalDetailNumber,
            Timestamp createTime, Timestamp updateTime) {
        this.technicalDetailName = technicalDetailName;
        this.technicalDetailNumber = technicalDetailNumber;

        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public String getTechnicalDetailName() {
        return technicalDetailName;
    }

    public void setTechnicalDetailName(String technicalDetailName) {
        this.technicalDetailName = technicalDetailName;
    }

    public Integer getTechnicalDetailNumber() {
        return technicalDetailNumber;
    }

    public void setTechnicalDetailNumber(Integer technicalDetailNumber) {
        this.technicalDetailNumber = technicalDetailNumber;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
