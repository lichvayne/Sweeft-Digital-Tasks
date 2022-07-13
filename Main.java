package com.company;

import java.util.LinkedList;
import java.util.Stack;


public class Main {

    LinkedList<String> peopleArray = new LinkedList<>();

    public static void main(String[] args) {
        Main main = new Main();
        int array[] = {0, -5, 17, 7, 3};
        System.out.println("Palindrome :" + main.isPalindrome("mom "));
        System.out.println("Minimum Quantity Of Coins:" + main.minSplit(1011));
        System.out.println("Minimum  Numbeer : " + main.notContains(array));
        System.out.println("Balanced Braces :" + main.isProperly("(()())"));
        System.out.println("Variant Quantity :" + main.countVariants(2));
        main.addToStack("Sandro");
        main.addToStack("Giorgi");
        main.addToStack("Nika");
        System.out.println(main.removeFromStack());

    }

    // 1 - დავალება
    boolean isPalindrome(String text) {
        String reversedText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversedText += text.charAt(i);
        }
        return (reversedText.trim().toLowerCase()
                .equals(text.toLowerCase().trim()));
    }

    // 2 - დავალება
    int minSplit(int amount) {
        int count = 0;
        int coinArray[] = {50, 20, 10, 5, 1};
        int i = 0;
        while (amount != 0) {
            if (amount >= coinArray[i]) {
                count += amount / coinArray[i];
                amount -= coinArray[i] * (amount / coinArray[i]);
            } else {
                i++;
            }
        }
        return count;
    }

    // 3 - დავალება
    int notContains(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min && element > 0) min = element;
        }
        return min - (min - 1);
    }

    // 4 - დავალება
    boolean isProperly(String sequence) {
        Stack<Character> bracesStack = new Stack();
        for (int i = 0; i < sequence.length(); i++) {
            if(sequence.charAt(i) =='('){
                bracesStack.push(sequence.charAt(i));
            }else {
                if(bracesStack.isEmpty()){
                return false;
               }
                else {

                    char deletedBrace = bracesStack.pop();
                    if (sequence.charAt(i) == ')' && deletedBrace != '(') return false;
                }
            }
        }
        if(bracesStack.isEmpty()){
            return true;
        }else return false;
    }

    // 5 - დავალება
    int countVariants(int stearsCount) {
        int fibonacciArray[] = new int[stearsCount + 1];
        fibonacciArray[0] = 1;
        if (stearsCount <= 0) return 0;
        fibonacciArray[1] = 1;
        if (stearsCount == 1) return fibonacciArray[1];
        fibonacciArray[2] = 2;
        for (int i = 3; i <= stearsCount; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray[stearsCount];
    }

    // 6 - დავალება
    void addToStack(String name){
        peopleArray.add(name);
    }
    String removeFromStack(){
        String people = peopleArray.get(peopleArray.size()-1);
        peopleArray.remove(peopleArray.size()-1);
        if(peopleArray.isEmpty()) return null;
        return people;
    }



}