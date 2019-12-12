package com.imomei.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imomei.common.res.IMoMeiPageReq;
import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import com.imomei.common.utils.SnowIDUtils;
import com.imomei.entity.Item;
import com.imomei.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Item控制层
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 分页查询Item
    @RequestMapping(value = "/getItemList", method = RequestMethod.GET)
    public IMoMeiResult getItemList(IMoMeiPageReq iMoMeiPageReq) {
        // 校验分页参数非空
        if (iMoMeiPageReq.getPageNum() != null && iMoMeiPageReq.getPageSize() != null) {
            // PageHelper分页封装
            Page<Object> page = PageHelper.startPage(iMoMeiPageReq.getPageNum(), iMoMeiPageReq.getPageSize());
            // 获得数据
            List<Item> itemList = itemService.getItemList(iMoMeiPageReq);
            // 获得总记录数
            long total = page.getTotal();
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING, itemList, total);
        } else {
            return new IMoMeiResult(IMoMeiResultCode.PAGE_ERROR, IMoMeiResultCode.PAGE_ERROR_STRING);
        }
    }

    // 根据ID查询Item
    @RequestMapping(value = "/getItemById", method = RequestMethod.GET)
    public IMoMeiResult getItemById(Item item) {
        // 校验ID不为空
        if (item.getItemId() != null) {
            Item getItem = itemService.getItemById(item);
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING, getItem);
        } else {
            return new IMoMeiResult(IMoMeiResultCode.MISSING_PARAM, IMoMeiResultCode.MISSING_PARAM_STRING);
        }
    }

    // 添加Item
    @RequestMapping(value = "/insItem", method = RequestMethod.POST)
    public IMoMeiResult insItem(@RequestBody Item item) {
        // 校验对象不为空
        if (item != null) {
            // 生成ID
            item.setItemId(new SnowIDUtils().nextId() + "");
            Integer count = itemService.insItem(item);
            if (count == 1) {
                return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
            }
            return new IMoMeiResult(IMoMeiResultCode.INSERT_ERROR, IMoMeiResultCode.INSERT_ERROR_STRING);
        } else {
            return new IMoMeiResult(IMoMeiResultCode.MISSING_PARAM, IMoMeiResultCode.MISSING_PARAM_STRING);
        }
    }

    // 更新Item
    @RequestMapping(value = "/updItem", method = RequestMethod.POST)
    public IMoMeiResult updItem(@RequestBody Item item) {
        // 校验ID不为空
        if (item.getItemId() != null) {
            Integer count = itemService.updItem(item);
            if (count == 1) {
                return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
            }
            return new IMoMeiResult(IMoMeiResultCode.UPDATE_ERROR, IMoMeiResultCode.UPDATE_ERROR_STRING);
        } else {
            return new IMoMeiResult(IMoMeiResultCode.MISSING_PARAM, IMoMeiResultCode.MISSING_PARAM_STRING);
        }
    }

    // 删除Item
    @RequestMapping(value = "/delItem", method = RequestMethod.POST)
    public IMoMeiResult delItem(@RequestBody Item item) {
        // 校验ID不为空
        if (item.getItemId() != null) {
            Integer count = itemService.delItem(item);
            if (count == 1) {
                return new IMoMeiResult(IMoMeiResultCode.SUCCESS, IMoMeiResultCode.SUCCESS_STRING);
            }
            return new IMoMeiResult(IMoMeiResultCode.DELETE_ERROR, IMoMeiResultCode.DELETE_ERROR_STRING);
        } else {
            return new IMoMeiResult(IMoMeiResultCode.MISSING_PARAM, IMoMeiResultCode.MISSING_PARAM_STRING);
        }
    }

}
