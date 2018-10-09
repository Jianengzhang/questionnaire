package com.questionnaire.ssm.module.login.mapper;

import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface SysUserMapper {

    Set<String> listUserRole(String userTel) throws Exception;

    Set<String> listUserPermission(String userTel) throws Exception;

}