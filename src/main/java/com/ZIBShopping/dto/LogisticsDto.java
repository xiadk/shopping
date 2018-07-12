package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.7.8
 *
 */
@Entity
@Table(name = "zib_logistics")
public class LogisticsDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="tracking_number")
    private String trackingNumber;
    @Column(name="link_man",nullable = true)
    private String linkMan;
    @Column
    private Long mobile;
    @Column
    private String address;
    @Column(name="update_time",nullable = false)
    private Date updateTime = new Date();

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
