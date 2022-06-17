package com.bezkoder.springjwt.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "project_product")
public class ProjectProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    // private Project project;
    //
    // @JsonIgnore
    // @OneToMany(targetEntity = Product.class, cascade = CascadeType.DETACH,
    // mappedBy = "projectProductId")
    // private List<Product> MYproduct = new ArrayList<>();

    @Column(name = "create_time", length = 20)
    private Timestamp createTime;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(targetEntity = Project.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectProduct() {
    }

    public ProjectProduct(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}