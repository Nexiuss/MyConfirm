/**
  * Copyright 2018 bejson.com 
  */
package xml.search;

/**
 * Auto-generated: 2018-12-20 11:3:4
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Organization extends Node{

    private String grade;
    private String modifiedTime;
    private Department Department;
    public void setGrade(String grade) {
         this.grade = grade;
     }
     public String getGrade() {
         return grade;
     }

    public void setModifiedTime(String modifiedTime) {
         this.modifiedTime = modifiedTime;
     }
     public String getModifiedTime() {
         return modifiedTime;
     }

    public void setDepartment(Department Department) {
         this.Department = Department;
     }
     public Department getDepartment() {
         return Department;
     }

}