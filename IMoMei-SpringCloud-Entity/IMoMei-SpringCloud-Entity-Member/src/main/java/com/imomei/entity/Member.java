package com.imomei.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Member implements Serializable {
    private String id;
    private String name;
    private int age;
}
