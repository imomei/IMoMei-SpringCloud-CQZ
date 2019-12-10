package com.imomei.mapper;

import com.imomei.entity.IntroductionEntity;

import java.util.List;

public interface IntroductionMapper {

    List<IntroductionEntity> getIntroductionList();

    IntroductionEntity getIntroductionById(String id);

    int updIntroduction(IntroductionEntity introductionEntity);

    int insIntroduction(IntroductionEntity introductionEntity);

    int delIntroduction(String id);
}
