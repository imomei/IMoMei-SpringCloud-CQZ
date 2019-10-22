package com.imomei.mapper;

import com.imomei.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {

    // 分页查询所有Member
    List<Member> getMemberList();

    // 根据ID查询Member
    Member getMemberByID(int id);

    // 新增Member
    int insMember(Member member);

    // 修改Member
    int updMember(Member member);

    // 根据ID删除Member
    int delMember(String id);
}
