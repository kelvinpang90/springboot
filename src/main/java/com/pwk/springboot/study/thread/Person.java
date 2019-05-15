package com.pwk.springboot.study.thread;

import java.time.LocalDate;

public class Person {

    public enum SEX{MALE,FEMALE}

    private String name;
    private SEX gender;
    private String email;
    private LocalDate birthday;

    public Person(String name, SEX gender, String email, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.birthday = birthday;
    }

    public int getAge(){
        return LocalDate.now().getYear()-birthday.getYear();
    }

    public void printPerson(){
        System.out.println(name+" "+gender.name()+" "+email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SEX getGender() {
        return gender;
    }

    public void setGender(SEX gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public synchronized void bow(Person p){
        System.out.format("%s:%s has bowed to me \n",this.name,p.getName());
        this.bowBack(p);

    }

    public synchronized void bowBack(Person p){
        System.out.format("%s:%s has bowed back to me \n",this.name,p.getName());
    }
}
