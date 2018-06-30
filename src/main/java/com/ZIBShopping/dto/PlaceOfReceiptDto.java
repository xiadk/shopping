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
    private String userId;
    //收货人
    @Column(nullable = true)
    private String consignee;
    @Column(length = 12,nullable = true)
    private Long phone;
    @Column(nullable = true)
    private String area;
    @Column(nullable = true)
    private String city;
    @Column(nullable = true)
    private String counties;
    @Column
    private String town;
    @Column(name="detailed_address",nullable = true)
    private String detailedAddress;
    @Column(name="update_time",nullable = true)
    private Date updateTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
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

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
