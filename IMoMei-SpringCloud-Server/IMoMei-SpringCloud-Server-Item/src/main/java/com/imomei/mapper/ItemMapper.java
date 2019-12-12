package com.imomei.mapper;

import com.imomei.common.res.IMoMeiPageReq;
import com.imomei.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Item数据层
 */
@Mapper
public interface ItemMapper {

    // 分页查询Item
    List<Item> getItemList(IMoMeiPageReq iMoMeiPageReq);

    // 根据ID查询Item
    Item getItemById(Item item);

    // 添加Item
    Integer insItem(Item item);

    // 更新Item
    Integer updItem(Item item);

    // 删除Item
    Integer delItem(Item item);
}
