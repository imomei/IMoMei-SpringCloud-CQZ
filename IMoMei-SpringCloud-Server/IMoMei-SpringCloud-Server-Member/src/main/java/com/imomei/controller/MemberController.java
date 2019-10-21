package com.imomei.controller;

import com.imomei.entity.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping(value = "/getMember")
    public Member getMember() {
        Member member = new Member();
        member.setId("1");
        member.setMemberName("张三");
        member.setMemberage(15);
        return member;
    }
}
