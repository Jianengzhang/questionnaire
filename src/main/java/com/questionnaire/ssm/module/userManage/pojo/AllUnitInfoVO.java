package com.questionnaire.ssm.module.userManage.pojo;

public class AllUnitInfoVO {
    private Long unitId;
    private String unitName;
    private String unitCode;
    private String unitLevel;
    private String unitProvince;
    private String unitCity;
    private String address;

    @Override
    public String toString() {
        return "AllUnitInfoVO{" +
                "unitId=" + unitId +
                ", unitName='" + unitName + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", unitLevel='" + unitLevel + '\'' +
                ", unitProvince='" + unitProvince + '\'' +
                ", unitCity='" + unitCity + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitLevel() {
        return unitLevel;
    }

    public void setUnitLevel(String unitLevel) {
        this.unitLevel = unitLevel;
    }

    public String getUnitProvince() {
        return unitProvince;
    }

    public void setUnitProvince(String unitProvince) {
        this.unitProvince = unitProvince;
    }

    public String getUnitCity() {
        return unitCity;
    }

    public void setUnitCity(String unitCity) {
        this.unitCity = unitCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
