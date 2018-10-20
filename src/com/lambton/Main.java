package com.lambton;

public class Main {

    public static void main(String[] args) {
	    System.out.println(LambtonStringTools.reverse("Lambton"));
        System.out.println(LambtonStringTools.binaryToDecimal("1000"));
        System.out.println(LambtonStringTools.binaryToDecimal("10001"));
        System.out.println(LambtonStringTools.initials("James tiberius kiRKqweqwe wqewqe"));
        System.out.println(LambtonStringTools.mostFrequent("lambtonisaCollege."));
        System.out.println(LambtonStringTools.replaceSubString("the dog jumped over the fence", "the", "that"));
    }
}
