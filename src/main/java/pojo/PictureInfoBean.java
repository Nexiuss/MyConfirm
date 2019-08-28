package pojo;

/**
 * 图片上传信息实体类
 */
public class PictureInfoBean {
	// 拍摄图片的设备id
	private String deviceid;
	
	// 拍摄图片的通道号
	private Integer channelid;
	
	private String alarmseq;
	
	// 图片拍摄时间
	private String datetime;
	
	// 图片名称
	private String name;
	
	// 报警类型, 用于ams2.0服务器区分图片信息
	private String type;

	private PictureInfoBean(Builder builder) {
		setDeviceid(builder.deviceid);
		setChannelid(builder.channelid);
		setAlarmseq(builder.alarmseq);
		setDatetime(builder.datetime);
		setName(builder.name);
		setType(builder.type);
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public Integer getChannelid() {
		return channelid;
	}

	public void setChannelid(Integer channelid) {
		this.channelid = channelid;
	}

	public String getAlarmseq() {
		return alarmseq;
	}

	public void setAlarmseq(String alarmseq) {
		this.alarmseq = alarmseq;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public static final class Builder {
		private String deviceid;
		private Integer channelid;
		private String alarmseq;
		private String datetime;
		private String name;
		private String type;

		public Builder() {
		}

		public Builder deviceid(String val) {
			deviceid = val;
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

		public Builder datetime(String val) {
			datetime = val;
			return this;
		}

		public Builder name(String val) {
			name = val;
			return this;
		}

		public Builder type(String val) {
			type = val;
			return this;
		}

		public PictureInfoBean build() {
			return new PictureInfoBean(this);
		}
	}
}
