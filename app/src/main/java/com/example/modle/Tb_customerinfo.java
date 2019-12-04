package com.example.modle;

public class Tb_customerinfo {   //顾客实体类
    private String cname;       //用户名
    private String cpwd;        //密码
    private String csex;        //性别
    private String ctele;       //电话
    private String cschool;     //所在学校
    private String cbuilding;   //楼栋
    private String cdormitory;  //寝室号

    public Tb_customerinfo(String cname,String cpwd,String csex,String ctele,String cschool,
                           String cbuilding,String cdormitory){
        super();
        this.cname = cname;
        this.cpwd = cpwd;
        this.csex = csex;
        this.ctele = ctele;
        this.cschool = cschool;
        this.cbuilding = cbuilding;
        this.cdormitory = cdormitory;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public String getCsex() {
        return csex;
    }

    public void setCsex(String csex) {
        this.csex = csex;
    }

    public String getCtele() {
        return ctele;
    }

    public void setCtele(String ctele) {
        this.ctele = ctele;
    }

    public String getCschool() {
        return cschool;
    }

    public void setCschool(String cschool) {
        this.cschool = cschool;
    }

    public String getCbuilding() {
        return cbuilding;
    }

    public void setCbuilding(String cbuilding) {
        this.cbuilding = cbuilding;
    }

    public String getCdormitory() {
        return cdormitory;
    }

    public void setCdormitory(String cdormitory) {
        this.cdormitory = cdormitory;
    }
}
