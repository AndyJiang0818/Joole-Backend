package com.bezkoder.springjwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity(name = "project")
public class Project {
    @Id
    @GeneratedValue
    private Integer id;

    // @Column(name = "user_id", length = 20)
    // private Integer user_id;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(targetEntity = ProjectProduct.class, cascade = CascadeType.REMOVE, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectProduct> projectProduct = new HashSet<>();

    @Column(name = "create_time", length = 20)
    private Timestamp createTime;

    @Column(name = "update_time", length = 20)
    private Timestamp updateTime;

    public Project() {
    }

    public Project(int id, User user, Timestamp createTime, Timestamp updateTime) {

        this.id = id;
        this.user = user;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User getUser() {
        return user;
    }

    public Collection<ProjectProduct> getProjectProduct() {
        return projectProduct;
    }

    public void setProjectProduct(Collection<ProjectProduct> projectProduct) {
        this.projectProduct = projectProduct;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProjectProduct(List<ProjectProduct> projectProduct) {
        this.projectProduct = projectProduct;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProjectId=" + id +
                ", user=" + user +
                ", projectProduct=" + projectProduct +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
