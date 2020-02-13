package com.hy.springboot.bean;

public class PPT {
    private String id;
    private String name;
    private String location;
    private Integer label1;
    private Integer label2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLabel1() {
        return label1;
    }

    public void setLabel1(Integer label1) {
        this.label1 = label1;
    }

    public int getLabel2() {
        return label2;
    }

    public void setLabel2(Integer label2) {
        this.label2 = label2;
    }

    public PPT(String id, String name, String location, Integer label1, Integer label2) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.label1 = label1;
        this.label2 = label2;
    }

    public PPT() {
    }

    @Override
    public String toString() {
        return "PPT{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", label1=" + label1 +
                ", label2=" + label2 +
                '}';
    }
}
