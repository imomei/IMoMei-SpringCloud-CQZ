package com.imomei.service.impl;

import com.imomei.common.res.IMoMeiPageReq;
import com.imomei.entity.Item;
import com.imomei.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Item服务层
 */
@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    // 分页查询Item
    public List<Item> getItemList(IMoMeiPageReq iMoMeiPageReq) {
        return itemMapper.getItemList(iMoMeiPageReq);
    }

    // 根据ID查询Item
    public Item getItemById(Item item) {
        // 从Redis查询
        Item redisItem = (Item) redisTemplate.opsForValue().get("Item_" + item.getItemId());
        // 校验
        if (redisItem != null) {
            // Redis中有数据
            return redisItem;
        } else {
            // Redis中没数据，从数据库查询
            Item itemById = itemMapper.getItemById(item);
            // 放入Redis中
            redisTemplate.opsForValue().set("Item_" + item.getItemId(), itemById);
            return itemById;
        }

    }

    // 删除Item
    public Integer delItem(Item item) {
        // 从缓存中删除
        redisTemplate.delete("Item_" + item.getItemId());
        return itemMapper.delItem(item);
    }

    // 更新Item
    public Integer updItem(Item item) {
        // 从缓存中删除
        redisTemplate.delete("Item_" + item.getItemId());
        return itemMapper.updItem(item);
    }

    // 添加Item
    public Integer insItem(Item item) {
        return itemMapper.insItem(item);
    }

}
