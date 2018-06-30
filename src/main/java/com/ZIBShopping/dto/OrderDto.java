package com.ZIBShopping.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.6.30
 *
 */
@Entity
@Table(name = "zib_order")
public class OrderDto implements Serializable{
    @Id
    private Long id;
    @Column(name="user_id")
    private String userId;
    @Column(name="place_of_receipt_id")
    private String PlaceOfReceiptId;
    @Column(name="zib_product_id")
    private String ZIBProductId;
    @Column(name="zib_product_name",length = 30)
    private String ZIBProductName;
    @Column(length = 6)
    private Long price;
    @Column(name="product_count",length = 6)
    private Long productCount;
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

    public String getPlaceOfReceiptId() {
        return PlaceOfReceiptId;
    }

    public void setPlaceOfReceiptId(String placeOfReceiptId) {
        PlaceOfReceiptId = placeOfReceiptId;
    }

    public String getZIBProductId() {
        return ZIBProductId;
    }

    public void setZIBProductId(String ZIBProductId) {
        this.ZIBProductId = ZIBProductId;
    }

    public String getZIBProductName() {
        return ZIBProductName;
    }

    public void setZIBProductName(String ZIBProductName) {
        this.ZIBProductName = ZIBProductName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}