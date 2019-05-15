package com.pwk.springboot.study;

public class Switch {
    public static void main(String[] args){
        int i = 0;
        if(args != null&& args.length>0){
            i = Integer.valueOf(args[0]);
            switch (i){
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
            }
        }

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
