package com.pwk.springboot.study.lambda;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Comparable<Person>, Serializable {

    @Override
    public int compareTo(@NonNull Person o) {
        return this.getAge()-o.getAge();
    }

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

    @Override
    public String toString(){
        return name+" "+gender.name()+" "+email;
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
}
