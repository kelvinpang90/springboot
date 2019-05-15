package com.pwk.springboot.study.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class Calculate {
    private static Stack<Integer> operandStack = new Stack<>();
    private static Stack<Character> operatorStack = new Stack<>();

    public static void main(String[] args){
        System.out.println(operateCalculation("1+2+3+4+5"));
    }
    //insert blank into each operator
    public static String insertBlank(String expression){
        String result = "";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/'||expression.charAt(i)=='('||expression.charAt(i)==')'){
                result +=" "+expression.charAt(i)+" ";
            }else{
                result +=expression.charAt(i);
            }
        }
        return result;
    }

    //process an operator
    public static void processAnOperator(Stack<Integer> operands,Stack<Character> operators){
        int operand1 = operands.pop();
        int operand2 = operands.pop();
        char operator = operators.pop();
        switch (operator){
            case '+':operands.push(operand1+operand2);
            case '-':operands.push(operand1-operand2);
            case '*':operands.push(operand1*operand2);
            case '/':operands.push(operand1/operand2);
        }
    }

    //calculate an expression(+-*/)
    public static int operateCalculation(String expression){
        expression = insertBlank(expression);
        String[] token = expression.split(" ");
        for(String str: token){
            if(StringUtils.isNotBlank(str)){
                if(str.trim().equals("+")||str.trim().equals("-")){
                    while(!operatorStack.isEmpty()&&(operatorStack.peek()=='+'||operatorStack.peek()=='-'||operatorStack.peek()=='*'||operatorStack.peek()=='/')){
                        processAnOperator(operandStack,operatorStack);
                    }
                    operatorStack.push(str.trim().charAt(0));
                }else if(str.trim().equals("*")||str.trim().equals("/")){
                    while(!operatorStack.isEmpty()&&(operatorStack.peek()=='*'||operatorStack.peek()=='/'))
                        processAnOperator(operandStack,operatorStack);
                }else if(str.trim().equals("(")){
                    operatorStack.push(str.trim().charAt(0));
                }else if(str.trim().equals(")")){
                    while (operatorStack.peek()!='(')
                        processAnOperator(operandStack,operatorStack);
                    operatorStack.pop();

                }else if(StringUtils.isNumeric(str)){
                    //if it is number
                    operandStack.push(Integer.valueOf(str));
                }
            }
        }
        if(!operatorStack.isEmpty())
            processAnOperator(operandStack,operatorStack);
        return operandStack.pop();
    }
}
