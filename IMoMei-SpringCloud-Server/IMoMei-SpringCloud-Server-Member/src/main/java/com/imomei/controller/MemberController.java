package com.imomei.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import com.imomei.mapper.MemberMapper;
import com.imomei.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;

    // 分页查询所有Member
    @GetMapping(value = "/getMemberList")
    public IMoMeiResult getMemberList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Member> memberList = memberMapper.getMemberList();
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "查询成功", memberList, page.getTotal() + "");
    }

    // 根据ID查询Member
    @GetMapping(value = "/getMemberByID")
    public IMoMeiResult getMemberByID(@RequestParam int id) {
        Member member = memberMapper.getMemberByID(id);
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "查询成功", member);
    }

    // 新增Member
    @PostMapping(value = "/setMember")
    public IMoMeiResult setMember(@RequestBody Member member) {
        member.setId(UUID.randomUUID().toString());
        int code = memberMapper.setMember(member);
        if (code == 1) {
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "新增成功");
        }
        return new IMoMeiResult(IMoMeiResultCode.ERROR, "新增失败");
    }

}
