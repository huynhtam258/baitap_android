package com.thigiuaki.t7_b5_huynhmanhtam;

public class Student {
    int id,gender;
    String name, address;
    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, int gender, String name, String address) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.address = address;
    }
}
