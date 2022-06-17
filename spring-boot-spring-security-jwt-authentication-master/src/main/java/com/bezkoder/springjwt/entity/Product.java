package com.bezkoder.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @ManyToOne(targetEntity = ProductType.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    // @ManyToone(tragetE = Story)
    // @Joins name = story_id
    // private Story story

    // @Column(name = "product_type_id", length = 20)
    // private Integer productTypeId;

    @ManyToOne(targetEntity = TechnicalDetail.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "technical_detail_id")
    private TechnicalDetail technicalDetail;

    // @Column(name = "technical_detail_id", length = 20)
    // private Integer technicalDetailId;

    @ManyToOne(targetEntity = Manufacturer.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "manufacturer_detail_id")
    private Manufacturer manufacturerDetailId;

    // @Column(name = "manufacturer_detail_id", length = 20)
    // private Integer manufacturerDetailId;

    @Column(name = "model_year", length = 20)
    private Integer modelYear;

    @ManyToOne(targetEntity = Sale.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "brand", length = 20)
    private String brand;

    @CreatedDate
    @Column(name = "create_time", length = 20)
    private Timestamp createTime;

    @Column(name = "update_time", length = 20)
    private Timestamp updateTime;

    @JsonIgnore
    @OneToMany(targetEntity = ProjectProduct.class, cascade = CascadeType.REMOVE, mappedBy = "product")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProjectProduct> ProjectProducts = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productType=" + productType +
                ", technicalDetail=" + technicalDetail +
                ", manufacturerDetailId=" + manufacturerDetailId +
                ", modelYear=" + modelYear +
                ", sale=" + sale +
                ", brand='" + brand + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"id\" : \"" + id +
                "\" , \"name\": \"" + name +
                "\" , \"productType\": \"" + productType +
                "\" , \"technicalDetail\": \"" + technicalDetail +
                "\" , \"manufacturerDetailId\": \"" + manufacturerDetailId +
                "\" , \"modelYear\": \"" + modelYear +
                "\" , \"sale\": \"" + sale +
                "\" , \"brand\": \"" + brand +
                "\" , \"createTime\": \"" + createTime +
                "\" , \"updateTime\": \"" + updateTime +
                "\"}";
    }

    public Product() {
    }

    public Product(String name, Integer modelYear, String brand, Timestamp createTime, Timestamp updateTime) {
        this.name = name;
        this.modelYear = modelYear;
        this.brand = brand;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public TechnicalDetail getTechnicalDetail() {
        return technicalDetail;
    }

    public void setTechnicalDetail(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
    }

    public Manufacturer getManufacturerDetailId() {
        return manufacturerDetailId;
    }

    public void setManufacturerDetailId(Manufacturer manufacturerDetailId) {
        this.manufacturerDetailId = manufacturerDetailId;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
