package com.imomei.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.imomei.common.res.IMoMeiResult;
import com.imomei.common.res.IMoMeiResultCode;
import com.imomei.mapper.MemberMapper;
import com.imomei.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private RedisTemplate redisTemplate;

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
        Member member;
        // 从Redis查询
        member = (Member) redisTemplate.opsForValue().get("Member_" + id);
        if (member == null) {
            // 从数据库查询
            member = memberMapper.getMemberByID(id);
            // 放入Redis
            redisTemplate.opsForValue().set("Member_" + id, member);
        }
        return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "查询成功", member);
    }

    // 新增Member
    @PostMapping(value = "/insMember")
    public IMoMeiResult insMember(@RequestBody Member member) {
        member.setId(UUID.randomUUID().toString());
        int code = memberMapper.insMember(member);
        if (code == 1) {
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "新增成功");
        }
        return new IMoMeiResult(IMoMeiResultCode.ERROR, "新增失败");
    }

    // 修改Member
    @PostMapping(value = "/updMember")
    public IMoMeiResult updMember(@RequestBody Member member) {
        int code = memberMapper.updMember(member);
        if (code == 1) {
            // 放入Redis
            redisTemplate.opsForValue().set("Member_" + member.getId(), member);
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "修改成功");
        }
        return new IMoMeiResult(IMoMeiResultCode.ERROR, "修改失败");
    }

    // 根据ID删除Member
    @PostMapping(value = "/delMember")
    public IMoMeiResult delMember(@RequestParam String id) {
        int code = memberMapper.delMember(id);
        if (code == 1) {
            // 从Redis删除
            redisTemplate.delete("Member_" + id);
            return new IMoMeiResult(IMoMeiResultCode.SUCCESS, "删除成功");
        }
        return new IMoMeiResult(IMoMeiResultCode.ERROR, "删除失败");
    }

}
