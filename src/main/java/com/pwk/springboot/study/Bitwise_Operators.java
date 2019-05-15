package com.pwk.springboot.study;

public class Bitwise_Operators {
    public static void main(String[] args){
        //5 convert to binary is 101, 101<<2 is 10100, 10100 to decimal is 20
        System.out.println(5<<2);
        System.out.println(20>>2);
        System.out.println(20>>>2);
        System.out.println(Integer.toBinaryString(-20));
        System.out.println(Integer.toBinaryString(-20>>>2));

        /**
         * & bitwise and
         * Binary AND Operator copies a bit to the result if it exists in both operands
         * example:101(5)&1100(12) is 0100(4)
         * 0101
         * 1100
         */
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(12));
        System.out.println("Decimal="+(5&12)+"Binary="+Integer.toBinaryString((5&12)));
        /**
         * | bitwise or
         * Binary OR Operator copies a bit if it exists in either operand.
         * example:101(5)|1100(12) is 1101(13)
         */
        System.out.println("Decimal="+(5|12)+"Binary="+Integer.toBinaryString((5|12)));

        /**
         * ^ bitwise XOR
         * Binary XOR Operator copies the bit if it is set in one operand but not both.
         * 0101
         * 1100
         * 1001
         */
        System.out.println("Decimal="+(5^12)+"Binary="+Integer.toBinaryString((5^12)));

        /**
         * ~Ones Complement
         * Binary Ones Complement Operator is unary and has the effect of 'flipping' bits.
         * 01001
         * 10110
         *
         * 11110
         * 00001
         *
         * 110010
         * 001101
         *
         *
         * 001101
         * 111011
         */
        System.out.println(Integer.parseInt("01001",2));
        System.out.println("Decimal="+~9+"Binary="+Integer.toBinaryString(~9));

        System.out.println(Integer.toBinaryString(30));
        System.out.println("Decimal="+~30+"Binary="+Integer.toBinaryString(~30));

        System.out.println(Integer.toBinaryString(50));
        System.out.println("Decimal="+~50+"Binary="+Integer.toBinaryString(~50));

        System.out.println(Integer.toBinaryString(-60));
        System.out.println("Decimal="+~-60+"Binary="+Integer.toBinaryString(~-60));
        int i = 1;
        if(i++>1&i++<3){
            System.out.println(i);
        }
        System.out.println(i);
    }
}
