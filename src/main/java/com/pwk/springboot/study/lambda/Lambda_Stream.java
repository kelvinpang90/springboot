package com.pwk.springboot.study.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda_Stream {
    public static void main(String[] str){
        Person p1 = new Person("Peter", Person.SEX.MALE,"abc@hotmail.com",LocalDate.of(1995,10,10));
        Person p2 = new Person("Kate", Person.SEX.FEMALE,"def@hotmail.com",LocalDate.of(1998,1,22));
        Person p3 = new Person("Brown", Person.SEX.MALE,"ghi@hotmail.com",LocalDate.of(1988,5,4));
        Person p4 = new Person("Ryan", Person.SEX.MALE,"ssa@hotmail.com",LocalDate.of(1985,5,4));
        List<Person> roster = new ArrayList<Person>();
        roster.add(p1);
        roster.add(p2);
        roster.add(p3);
        roster.add(p4);

        for(Person p:roster){
            System.out.println(p.getAge());
        }

        Collections.sort(roster);

        for(Person p:roster){
            System.out.println(p.getAge());
        }


        System.out.println(p1.getAge());
        System.out.println(p2.getAge());
        System.out.println(p3.getAge());

        processPersonsWithFunction(
                roster,
                person -> person.getAge()>=18&&person.getAge()<=25,
                person -> person.getEmail(),
                email-> System.out.println(email));

        processElements(
                roster,
                person -> person.getAge()>=18&&person.getAge()<=25&&person.getGender()==Person.SEX.MALE,
                person -> person.getEmail(),
                email-> System.out.println(email));

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        //Stream
        //iterate each name
        list.stream().filter(person -> person.getGender()== Person.SEX.MALE).forEach(person -> System.out.println(person.getName()));
        //get average age
        System.out.println("average age="+list.stream().mapToInt(Person::getAge).average().getAsDouble());
        //get age sum
        System.out.println("total age="+list.stream().mapToInt(Person::getAge).sum());
        System.out.println("total age="+list.stream().map(Person::getAge).reduce(0,(a,b)->a+b));
        //group by sex
        Map<Person.SEX,List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println(map);
        //filter male name and put all names into list
        System.out.println(list.stream().filter(p->p.getGender()== Person.SEX.MALE).map(Person::getName).collect(Collectors.toList()));
        System.out.println(list.stream().filter(pp->pp.getGender()==Person.SEX.MALE));

    }

    public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person,String> mapper, Consumer<String> block){
        Predicate p = o -> {
            Person p12 = (Person)o;
            return p12.getGender()== Person.SEX.MALE;
        };
        for(Person p1:roster){
            if(tester.and(p).test(p1)){
                String data = mapper.apply(p1);
                block.accept(data);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source,Predicate<X> tester,Function<X,Y> mapper,Consumer<Y> block) {
        for(X p:source){
            if(tester.test(p)){
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}
