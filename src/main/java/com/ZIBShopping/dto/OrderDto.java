package com.ZIBShopping.dto;

import com.ZIBShopping.enums.OrderType;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private Long userId;
    @Column(name="logistics_id")
    private String logisticsId;
    @Column(name="place_of_receipt_id")
    private String placeOfReceiptId;
    @Column(name="zib_product_id")
    private String productId;
    @Column
    private String pic;
    @Column(name="goods_name")
    private String goodsName;
    @Column(length = 6)
    private Long price;
    //购买产品数量
    @Column(name="product_count",length = 6)
    private Long productCount;
    @Column
    private String remark;
    @Column(length = 2)
    private Long status = 0l;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "status_value",length = 30)
    private String statusValue = OrderType.AWAIT_PAY.getName();
    @Column(name="update_time",nullable = false)
    private Date updateTime = new Date();

    public String getLogisticsId() {
        return logisticsId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(String statusValue) {
        this.statusValue = statusValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPlaceOfReceiptId() {
        return placeOfReceiptId;
    }

    public void setPlaceOfReceiptId(String placeOfReceiptId) {
        this.placeOfReceiptId = placeOfReceiptId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
