package com.questionnaire.ssm.module.userManage.service.impl;

import com.questionnaire.ssm.module.generated.mapper.UnitMapper;
import com.questionnaire.ssm.module.generated.pojo.Unit;
import com.questionnaire.ssm.module.global.enums.CodeForVOEnum;
import com.questionnaire.ssm.module.global.enums.DBTableEnum;
import com.questionnaire.ssm.module.global.exception.OperateDBException;
import com.questionnaire.ssm.module.userManage.service.UnitInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UnitInfoServiceImpl implements UnitInfoService {
    @Override
    @Transactional
    public void InsertUnitInfo(Unit unit) {
        Unit newUnit = new Unit();
        //设置单位名称
        if (unit.getUnitName() == null || unit.getUnitName().isEmpty()) {
            throw new OperateDBException(CodeForVOEnum.NEW_UNIT_DATA_ERROR, "插入单位表格时");
        }

        newUnit.setUnitName(unit.getUnitName());
        if (unit.getUnitCode() == null || unit.getUnitCode().isEmpty()) {
            throw new OperateDBException(CodeForVOEnum.NEW_UNIT_DATA_ERROR, "插入单位表格时");
        }
        newUnit.setUnitCode(unit.getUnitCode());

        newUnit.setUnitLevel(unit.getUnitLevel());
        newUnit.setUnitProvince(unit.getUnitProvince());
        newUnit.setUnitCity(unit.getUnitCity());
        newUnit.setAddress(unit.getAddress());

        try {
            unitMapper.insert(newUnit);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new OperateDBException(CodeForVOEnum.DB_INSERT_FAIL, DBTableEnum.UNIT.getTableName());
        }
    }

    private UnitMapper unitMapper;
    private final static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    public UnitInfoServiceImpl( UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }
}
