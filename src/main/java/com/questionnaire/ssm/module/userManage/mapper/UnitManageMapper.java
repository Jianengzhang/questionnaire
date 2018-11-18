package com.questionnaire.ssm.module.userManage.mapper;

import com.questionnaire.ssm.module.generated.pojo.Unit;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitManageMapper {
    int insertUnit(Unit unit);
}
