package com.pwk.springboot.study.collection;

import java.util.*;

public class Basic{
    public static void main(String[] args){
        //Set
        String[] strings = {"b","b","c","d","a","a"};
        Integer[] integers = {5,4,3,2,1};
        //convert array to hashSet
//        Set<String> set = Arrays.stream(strings).collect(Collectors.toSet());
//        for(String str:set){
//            System.out.println(str);
//        }
//
//        //classify unique and duplicate elements
//        //把集合中重复和单独的元素分离出来
//        Set<String> unique = new HashSet<>();
//        Set<String> duplicate = new HashSet<>();
//        for(String str:strings){
//            if(!unique.add(str))
//                duplicate.add(str);
//        }
//        unique.removeAll(duplicate);
//        System.out.println(unique);
//        System.out.println(duplicate);

        //randomly permute the specified list
        List<String> list = new ArrayList<>(Arrays.asList(strings));

//        //this operation always throws Exception
//        List<String> list1 = Arrays.asList(strings);
//        list1.clear();

//        Collections.shuffle(list);
//        System.out.println(list);
//        list.subList(0,1).clear();
//        System.out.println(list);

//        Poker p = new Poker();
//        p.shuffle();
//        System.out.println(p.size()+ p.toString());
//        List<String> player1 = p.dealHand(13);
//        System.out.println(p.size()+p.toString());
//        System.out.println(player1.size()+" "+player1);

//        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1,2,3,4,5));
//        queue.add(6);
//        queue.remove();
//        //get the first element
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue);

//        Queue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        queue1.offer(7);
//        queue1.offer(6);
//        queue1.offer(5);
//        queue1.offer(4);
//        queue1.offer(3);
//        queue1.offer(2);
//        queue1.offer(1);
//        System.out.println(queue1);
//        queue1.poll();
//        System.out.println(queue1);

        Map<Integer,List> map = new HashMap<>();
        int i = 1;
        for(String str:strings){
            Poker poker = new Poker();
            poker.shuffle();
            map.put(i++,poker.dealHand(5));
        }
        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map);
        System.out.println(map.entrySet());


//        //Singleton
        String init[] = { "One","One", "Two", "Three", "One", "Two", "Three" };
        List list1 = new ArrayList(Arrays.asList(init));
        List list2 = new ArrayList(Arrays.asList(init));
        System.out.println("list1="+list1);
        list1.add(1,"Two");
        System.out.println("list1="+list1);

        List<List> list3 = Collections.nCopies(1,list2);
        System.out.println("list3="+list3);
//        list1.remove("One");
//        System.out.println("List1 value: "+list1);
//        list2.removeAll(Collections.singleton("One"));
//        System.out.println(Collections.singleton("One"));
//        System.out.println("The SingletonList is :"+list2);
        System.out.println(Collections.binarySearch(list1,"Three"));

        Vector<String> list4 = new Vector<>();

        Set set = new LinkedHashSet();


        Set<Season> seasons = EnumSet.allOf(Season.class);
        Set<Month> months = EnumSet.allOf(Month.class);
    }



    enum Season {
        SPRING, SUMMER, AUTUMN, WINTER;
    }

    enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }
}
