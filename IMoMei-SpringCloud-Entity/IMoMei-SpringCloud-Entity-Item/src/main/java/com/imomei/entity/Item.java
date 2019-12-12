package com.imomei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 商品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item implements Serializable {
    private String itemId;
    private String itemName;
    private String itemPrice;
    private String itemTypeId;
    private String itemStatus;
}
