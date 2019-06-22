package pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class AlertInfoBean
{
	private long id;
	
	@ApiModelProperty(value = "设备编号")
    private String deviceid;

	@ApiModelProperty(value = "报警日志类型:1-视频丢失,2-外部报警,3-移动侦测,4-视频遮挡,5-硬盘满,6-硬盘故障,7-光纤报警,8-GPS报警,9跟踪算法报警," +
			"10-越线算法报警,11-入侵算法报警,12-徘徊算法报警,13-逆行算法报警,14-遗留算法报警,15-遗失算法报警,16-喷涂算法报警,17-烟感报警,18-电线过载报警," +
			"24-报警输入(远程),28-车牌识别,29-人脸识别,30-周界检测,31-轨迹检测,32-拌线检测,33-场景变换,34-遗失检测,35-遗留检测,36-偏色检测,37-失焦检测,38-人数统计," +
			"100-设备断线,200-停止录像(平台),0-未知")
	private String type;

	@ApiModelProperty(value = "状态 1-报警开始   2-报警结束")
	private Integer state;

	@ApiModelProperty(value = "报警时间")
	private String alarmtime;

	@ApiModelProperty(value = "通道")
    private Integer channelid;

	// 确认时间
	@ApiModelProperty(value = "确认时间")
	private String confirmtime;
	// 确认状态  0-未确认,1-已确认,2-误报,3-核实
	@ApiModelProperty(value = "确认状态 0-未确认,1-已确认,2-误报,3-核实")
	private Integer confirmstate;

	// 确认人
	@ApiModelProperty(value = "确认人")
	private String confirmUser;

	private String alarmseq;//关联报警图片

	private Integer domain;//域信息

	@ApiModelProperty(value = "详情")
	private String detail;

	@ApiModelProperty(value = "报警结束报警的时间")
	private String alarmEndTime;
	@ApiModelProperty(value = "报警图片")
	private String picUrl;

	@ApiModelProperty(value = "报警等级 0-紧急  1-重要 2-一般")
	private Integer alarmLevel;

	@ApiModelProperty(value = "设备的位置")
	private String location;

	@ApiModelProperty(value = "设备ip地址")
	private String deviceIp;

	@ApiModelProperty(value = "报警设备名称")
	private String alarmDeviceName;


   /*
   * 以下属性传值字段
   * */
   	private String[] types;//多类型查询
	private List<String> deviceids;//当前用户拥有权限的设备id

	@ApiModelProperty(value = "开始时间")
	private String timeBegin;//报警时间开始

	@ApiModelProperty(value = "结束时间")
	private String timeEnd;//报警时间结束

	@ApiModelProperty(value = "通道类型")
	private Integer channelType;//客户端查询用通道类型

	@ApiModelProperty(value = "消息")
    private String message;

    private String strAlarmtime;

    private String alarmtimeStr;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;
    

	
	@ApiModelProperty(value = "组织结构")
    private String coding;


    private String title;//
    private String devicesid;
    private Integer alertlistisuse;
    private String alertid;
    private Integer alertlisttype;
    private Integer alertlistgrade;

    private List<String> alertImgUrls;

    private Integer subtype;
	// 报警确认时间的检索开始时间
	@ApiModelProperty(value = "确认检索开始时间")
	private String confirmTimeBegin;

	// 报警确认时间的检索结束时间
	@ApiModelProperty(value = "确认检索结束时间")
	private String confirmTimeEnd;
	//服务器报警字段
	@JsonIgnore
	private String serverDevid;//服务器设备编号
	@JsonIgnore
	private String serverName; //服务器名称
	// @JsonIgnore
	private String serverIP; //服务器名称

	private AlertInfoBean(Builder builder) {
		setDeviceid(builder.deviceid);
		setType(builder.type);
		setState(builder.state);
		setAlarmtime(builder.alarmtime);
		setChannelid(builder.channelid);
		setAlarmseq(builder.alarmseq);
		setDetail(builder.detail);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAlarmtime() {
		return alarmtime;
	}

	public void setAlarmtime(String alarmtime) {
		this.alarmtime = alarmtime;
	}

	public Integer getChannelid() {
		return channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}

	public String getConfirmtime() {
		return confirmtime;
	}

	public void setConfirmtime(String confirmtime) {
		this.confirmtime = confirmtime;
	}

	public Integer getConfirmstate() {
		return confirmstate;
	}

	public void setConfirmstate(Integer confirmstate) {
		this.confirmstate = confirmstate;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public String getAlarmseq() {
		return alarmseq;
	}

	public void setAlarmseq(String alarmseq) {
		this.alarmseq = alarmseq;
	}

	public Integer getDomain() {
		return domain;
	}

	public void setDomain(Integer domain) {
		this.domain = domain;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAlarmEndTime() {
		return alarmEndTime;
	}

	public void setAlarmEndTime(String alarmEndTime) {
		this.alarmEndTime = alarmEndTime;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(Integer alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getAlarmDeviceName() {
		return alarmDeviceName;
	}

	public void setAlarmDeviceName(String alarmDeviceName) {
		this.alarmDeviceName = alarmDeviceName;
	}

	/*
	* 以下为传值字段
	* */

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStrAlarmtime() {
		return strAlarmtime;
	}

	public void setStrAlarmtime(String strAlarmtime) {
		this.strAlarmtime = strAlarmtime;
	}

	public String getAlarmtimeStr() {
		return alarmtimeStr;
	}

	public void setAlarmtimeStr(String alarmtimeStr) {
		this.alarmtimeStr = alarmtimeStr;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(String timeBegin) {
		this.timeBegin = timeBegin;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Integer getChannelType() {
		return channelType;
	}

	public void setChannelType(Integer channelType) {
		this.channelType = channelType;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDevicesid() {
		return devicesid;
	}

	public void setDevicesid(String devicesid) {
		this.devicesid = devicesid;
	}

	public Integer getAlertlistisuse() {
		return alertlistisuse;
	}

	public void setAlertlistisuse(Integer alertlistisuse) {
		this.alertlistisuse = alertlistisuse;
	}

	public String getAlertid() {
		return alertid;
	}

	public void setAlertid(String alertid) {
		this.alertid = alertid;
	}

	public Integer getAlertlisttype() {
		return alertlisttype;
	}

	public void setAlertlisttype(Integer alertlisttype) {
		this.alertlisttype = alertlisttype;
	}

	public Integer getAlertlistgrade() {
		return alertlistgrade;
	}

	public void setAlertlistgrade(Integer alertlistgrade) {
		this.alertlistgrade = alertlistgrade;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public List<String> getAlertImgUrls() {
		return alertImgUrls;
	}

	public void setAlertImgUrls(List<String> alertImgUrls) {
		this.alertImgUrls = alertImgUrls;
	}

	public Integer getSubtype() {
		return subtype;
	}

	public void setSubtype(Integer subtype) {
		this.subtype = subtype;
	}

	public String getConfirmTimeBegin() {
		return confirmTimeBegin;
	}

	public void setConfirmTimeBegin(String confirmTimeBegin) {
		this.confirmTimeBegin = confirmTimeBegin;
	}

	public String getConfirmTimeEnd() {
		return confirmTimeEnd;
	}

	public void setConfirmTimeEnd(String confirmTimeEnd) {
		this.confirmTimeEnd = confirmTimeEnd;
	}

	public String getServerDevid() {
		return serverDevid;
	}

	public void setServerDevid(String serverDevid) {
		this.serverDevid = serverDevid;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public List<String> getDeviceids() {
		return deviceids;
	}

	public void setDeviceids(List<String> deviceids) {
		this.deviceids = deviceids;
	}


	public static final class Builder {
		private String deviceid;
		private String type;
		private Integer state;
		private String alarmtime;
		private Integer channelid;
		private String alarmseq;
		private String detail;

		public Builder() {
		}

		public Builder deviceid(String val) {
			deviceid = val;
			return this;
		}

		public Builder type(String val) {
			type = val;
			return this;
		}

		public Builder state(Integer val) {
			state = val;
			return this;
		}

		public Builder alarmtime(String val) {
			alarmtime = val;
			return this;
		}

		public Builder channelid(Integer val) {
			channelid = val;
			return this;
		}

		public Builder alarmseq(String val) {
			alarmseq = val;
			return this;
		}

		public Builder detail(String val) {
			detail = val;
			return this;
		}

		public AlertInfoBean build() {
			return new AlertInfoBean(this);
		}
	}
}
