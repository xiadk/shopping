package com.ZIBShopping.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zib_student")
public class Student implements Serializable {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

}
