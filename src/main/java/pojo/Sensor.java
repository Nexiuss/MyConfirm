/**
  * Copyright 2018 bejson.com 
  */
package pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Auto-generated: 2018-04-17 17:47:16
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Sensor {

	@ApiModelProperty(value = "通用id，气象历史时，表示气象历史表主键id，气象报警，表示气象报警主键id")
	private int commonId;
	@ApiModelProperty(value = "气象类型  1-空温	2-空湿	3-光照	4-CO2	5-噪音	6-土湿	7-风向	8-风速")
    private int id;
    @ApiModelProperty(value = "气象信息名称")
    private String name;
    @ApiModelProperty(value = "气象信息值,当气象类型id为7时，0：北风  1：东北风 2：东风 3：东南风 4：南风 5：西南风 6：西风 7：西北风")
    private String value;
    @ApiModelProperty(value = "气象信息单位")
    private String unit;

    private Sensor(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setValue(builder.value);
        setUnit(builder.unit);
    }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setValue(String value) {
         this.value = value;
     }
     public String getValue() {
         return value;
     }

    public void setUnit(String unit) {
         this.unit = unit;
     }
     public String getUnit() {
         return unit;
     }
	public int getCommonId() {
		return commonId;
	}
	public void setCommonId(int commonId) {
		this.commonId = commonId;
	}


    public static final class Builder {
        private int id;
        private String name;
        private String value;
        private String unit;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder value(String val) {
            value = val;
            return this;
        }

        public Builder unit(String val) {
            unit = val;
            return this;
        }

        public Sensor build() {
            return new Sensor(this);
        }
    }
}