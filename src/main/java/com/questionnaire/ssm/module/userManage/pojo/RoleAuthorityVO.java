package com.questionnaire.ssm.module.userManage.pojo;

/**
 * Created by 郑晓辉 on 2017/5/23.
 * Description: 用户角色权限信息
 * modified by 张佳能 on 2018/9/18
 */
public class RoleAuthorityVO {
    //用户名
    private String account;
    //用户真实姓名
    private String realName;
    //用户角色
    private String userRole;
    //用户单位id
    private String unitName;
    //用户账户是否有效
    private String isAccountValid;

    @Override
    public String toString() {
        return "RoleAuthorityVO{" +
                "account='" + account + '\'' +
                ", realName='" + realName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", unit_id=" + unitName + '\'' +
                ", isAccountValid=" + isAccountValid +
                '}';
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getIsAccountValid() {
        return isAccountValid;
    }

    public void setIsAccountValid(String isAccountValid) {
        this.isAccountValid = isAccountValid;
    }
}
