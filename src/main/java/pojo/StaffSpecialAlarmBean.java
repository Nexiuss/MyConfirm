/**
 * FileName: StaffSpecialAlarmBean
 * Author:   Administrator
 * Date:     2019/7/10 15:26
 * Description:
 */
package pojo;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;

import java.util.concurrent.TimeUnit;

public class StaffSpecialAlarmBean {
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("人员表id")
    private Integer staffId;
    @ApiModelProperty("身份证号")
    private String idcard;
    @ApiModelProperty("人员名称")
    private String name;

    @ApiModelProperty("计划创建时间")
    private String createTime;

    @ApiModelProperty("周期")
    private Long period;

    @ApiModelProperty("周期单位")
    private TimeUnit periodUnit;

    @ApiModelProperty("性别")
    private String sex;
    // 年龄
    @ApiModelProperty("年龄")
    private Integer age;
    // 单元编号
    @ApiModelProperty("单元编号")
    private String unitCode;

    // 楼房编号
    @ApiModelProperty("楼层编号")
    private String buildingCode;

    @ApiModelProperty("距离最近识别间隔时间")
    private String interval;

    @ApiModelProperty("最近人脸识别时间")
    private String lastFaceTime;

    @ApiModelProperty("最近人脸识别时间")
    private String alarmtime;

    private String type = "staff_special";

    private String coding;

    @ApiModelProperty("确认状态 0-未确认,1-已确认")
    private int confirmState;

    private String confirmUser;

    private String confirmTime;

    private StaffSpecialAlarmBean(Builder builder) {
        id = builder.id;
        staffId = builder.staffId;
        idcard = builder.idcard;
        name = builder.name;
        createTime = builder.createTime;
        period = builder.period;
        periodUnit = builder.periodUnit;
        sex = builder.sex;
        age = builder.age;
        unitCode = builder.unitCode;
        buildingCode = builder.buildingCode;
        interval = builder.interval;
        lastFaceTime = builder.lastFaceTime;
        alarmtime = builder.alarmtime;
        coding = builder.coding;
    }

    public static final class Builder {
        private Integer id;
        private Integer staffId;
        private String idcard;
        private String name;
        private String createTime;
        private Long period;
        private TimeUnit periodUnit;
        private String sex;
        private Integer age;
        private String unitCode;
        private String buildingCode;
        private String interval;
        private String lastFaceTime;
        private String alarmtime;
        private String coding;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder staffId(Integer val) {
            staffId = val;
            return this;
        }

        public Builder idcard(String val) {
            idcard = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder createTime(String val) {
            createTime = val;
            return this;
        }

        public Builder period(Long val) {
            period = val;
            return this;
        }

        public Builder periodUnit(TimeUnit val) {
            periodUnit = val;
            return this;
        }

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder unitCode(String val) {
            unitCode = val;
            return this;
        }

        public Builder buildingCode(String val) {
            buildingCode = val;
            return this;
        }

        public Builder interval(String val) {
            interval = val;
            return this;
        }

        public Builder lastFaceTime(String val) {
            lastFaceTime = val;
            return this;
        }

        public Builder alarmtime(String val) {
            alarmtime = val;
            return this;
        }

        public Builder coding(String val) {
            coding = val;
            return this;
        }

        public StaffSpecialAlarmBean build() {
            return new StaffSpecialAlarmBean(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public TimeUnit getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(TimeUnit periodUnit) {
        this.periodUnit = periodUnit;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getLastFaceTime() {
        return lastFaceTime;
    }

    public void setLastFaceTime(String lastFaceTime) {
        this.lastFaceTime = lastFaceTime;
    }

    public String getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(String alarmtime) {
        this.alarmtime = alarmtime;
    }

    public String getType() {
        return type;
    }


    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public int getConfirmState() {
        return confirmState;
    }

    public void setConfirmState(int confirmState) {
        this.confirmState = confirmState;
    }

    public String getConfirmUser() {
        return confirmUser;
    }

    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Override
    public String toString() {
        return "StaffSpecialAlarmBean{" +
                "id=" + id +
                ", staffId=" + staffId +
                ", idcard='" + idcard + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", period=" + period +
                ", periodUnit=" + periodUnit +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", unitCode='" + unitCode + '\'' +
                ", buildingCode='" + buildingCode + '\'' +
                ", interval='" + interval + '\'' +
                ", lastFaceTime='" + lastFaceTime + '\'' +
                ", alarmtime='" + alarmtime + '\'' +
                ", type='" + type + '\'' +
                ", coding='" + coding + '\'' +
                '}';
    }

    public StaffSpecialAlarmBean() {
    }

    public static void main(String[] args) {
        String str = "{" +
                "confirmState : 1" +
                "}";
        StaffSpecialAlarmBean staffSpecialAlarmBean = JSON.parseObject(str, StaffSpecialAlarmBean.class);

        System.out.println(staffSpecialAlarmBean);
    }
}
