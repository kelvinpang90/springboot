package com.pwk.springboot.study;

import com.pwk.springboot.study.lambda.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stream {
    public static void main(String[] args){
        Person p1 = new Person("Peter", Person.SEX.MALE,"abc@hotmail.com", LocalDate.of(1995,10,10));
        Person p2 = new Person("Kate", Person.SEX.FEMALE,"def@hotmail.com",LocalDate.of(1998,1,22));
        Person p3 = new Person("Brown", Person.SEX.MALE,"ghi@hotmail.com",LocalDate.of(1988,5,4));
        Person p4 = new Person("Ryan", Person.SEX.MALE,"ssa@hotmail.com",LocalDate.of(1985,5,4));

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        list.stream().filter(person -> person.getAge()>=10).forEach(System.out::print);

    }
}
