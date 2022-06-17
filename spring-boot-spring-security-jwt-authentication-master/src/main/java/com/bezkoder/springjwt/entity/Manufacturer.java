package com.bezkoder.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Entity(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_name", length = 20)
    private String userName;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "department", length = 20)
    private String department;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "web_url", length = 20)
    private String webUrl;


    @Column(name = "create_time", length = 20)
    private Timestamp createTime;


    @Column(name = "update_time", length = 20)
    private Timestamp updateTime;

    @JsonIgnore
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.REMOVE, mappedBy = "manufacturerDetailId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> products = new ArrayList<>();


    public List<Product> getProducts(){
        return products;
    }

    public void addProducts(Product product) {
        if(products.contains(product)){
            return;
        }
        products.add(product);
        product.setManufacturerDetailId(this);
    }

    public void removeProducts(Product product){
        if(!products.contains(product)){
            return;
        }
        products.remove(product);
        product.setManufacturerDetailId(null);
    }

    @Override
    public String toString(){
        return "Manufacturer{" + "id=" + id + "}";
    }

    public String toJson(List<String> entries){
        String result = null;
        List<String> colsContent = new ArrayList<>();
        for(String entry: entries) {
            colsContent.add(entry);
        }
        result = "{" + String.join("," , colsContent) + "}";
        return String.format("{\"ManufacturerId\" : \"%d\", \"content\" : \"%s\"}" , getId(), result);

    }


    public Manufacturer() {
    }

    public Manufacturer(String userName, String password,
                        String department, String phone,
                        String email, String webUrl,
                        Timestamp createTime, Timestamp updateTime) {
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.phone = phone;
        this.email = email;
        this.webUrl = webUrl;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
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
