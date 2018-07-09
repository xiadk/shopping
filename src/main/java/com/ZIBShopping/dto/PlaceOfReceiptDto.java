package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.6.30
 * 收货地址
 */
@Entity
@Table(name = "zib_place_of_receipt")
public class PlaceOfReceiptDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private Long userId;

    //收货人
    @Column(name="link_man",nullable = false)
    private String linkMan;
    @Column(length = 12,nullable = false)
    private Long mobile;
    @Column(nullable = false)
    private String area;
    @Column(nullable = false)
    private String city;
    //县、市
    @Column(nullable = false)
    private String counties;
    //镇
    @Column
    private String town;
    //详细地址
    @Column(name="detailed_address",nullable = false)
    private String address;
    @Column(length = 6)
    private Long code;
    @Column(name = "is_default")
    private Boolean isDefault = true;
    @Column(name="update_time",nullable = false)
    private Date updateTime = new Date();
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounties() {
        return counties;
    }

    public void setCounties(String counties) {
        this.counties = counties;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
