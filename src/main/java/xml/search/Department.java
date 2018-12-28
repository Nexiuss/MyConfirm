/**
  * Copyright 2018 bejson.com 
  */
package xml.search;
import java.util.List;

/**
 * Auto-generated: 2018-12-20 11:3:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Department extends Node{

    private String coding;
    private String domainId;
    private String id;
    private String name;
    private Device Device;
    private String type;
    private List<Department> Department;

    public void setCoding(String coding) {
         this.coding = coding;
     }
     public String getCoding() {
         return coding;
     }

    public void setDomainId(String domainId) {
         this.domainId = domainId;
     }
     public String getDomainId() {
         return domainId;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setDevice(Device Device) {
         this.Device = Device;
     }
     public Device getDevice() {
         return Device;
     }

    public void setDepartment(List<Department> Department) {
         this.Department = Department;
     }
     public List<Department> getDepartment() {
         return Department;
     }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}