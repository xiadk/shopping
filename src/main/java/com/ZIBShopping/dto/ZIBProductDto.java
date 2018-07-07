package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.6.30
 * 产品
 */
@Entity
@Table(name = "zib_product")
public class ZIBProductDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 6)
    private Long price;
    //销售量
    @Column(name="sales_count",length = 6)
    private Long salesCount;
    //库存量
    @Column(name="repertory_count",length = 6)
    private Long repertoryCount;
    @Column(name="img_url",nullable = false)
    private String imgUrl;
    //总量
    @Column(name="all_count",length = 6)
    private Long allCount;
    @Column(name="update_time",nullable = false)
    private Date updateTime = new Date();

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Long salesCount) {
        this.salesCount = salesCount;
    }

    public Long getRepertoryCount() {
        return repertoryCount;
    }

    public void setRepertoryCount(Long repertoryCount) {
        this.repertoryCount = repertoryCount;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
