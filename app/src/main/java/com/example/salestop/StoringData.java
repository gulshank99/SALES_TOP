package com.example.salestop;

public class StoringData {
     public String fname  ;
     public  String lname  ;
     public  String name1  ;
     public  String dob1 ;
     public  String gen  ;
     public  String psd  ;


    public StoringData() {
    }

    public StoringData(String fname, String lname, String name1, String dob1, String gen, String psd) {
        this.fname = fname;
        this.lname = lname;
        this.name1 = name1;
        this.dob1 = dob1;
        this.gen = gen;
        this.psd = psd;

    }
//    public StoringData(String fname, String lname) {
//        this.fname = fname;
//        this.lname = lname;
//    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }



    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDob1() {
        return dob1;
    }

    public void setDob1(String dob1) {
        this.dob1 = dob1;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
}
