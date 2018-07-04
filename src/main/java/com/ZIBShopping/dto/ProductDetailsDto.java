package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.7.2
 */
@Entity
@Table(name = "zib_product_details",uniqueConstraints = {@UniqueConstraint(columnNames={"product_id"})})
public class ProductDetailsDto  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_id",nullable = false)
    private String productId;
    @Column(name="viewpager_url",nullable = false)
    private String viewpagerUrl;
    @Column(name="img_url",nullable = false)
    private String imgUrl;
    @Column(name="update_time",nullable = false)
    private Date updateTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getViewpagerUrl() {
        return viewpagerUrl;
    }

    public void setViewpagerUrl(String viewpagerUrl) {
        this.viewpagerUrl = viewpagerUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
