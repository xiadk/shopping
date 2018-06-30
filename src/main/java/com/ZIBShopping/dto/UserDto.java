package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * zjh 2018.6.30
 *
 */
@Entity
@Table(name = "zib_user")
public class UserDto implements Serializable {
    @Id
    private Long id;
    @Column
    private String name;
    @Column(length = 12,nullable = true)
    private Long phone;
    @Column(name="update_time",nullable = true)
    private Date updateTime = new Date();

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
