package com.company.exception;

public class TestCustomException {
    public static void validate(int age) throws InvalidAgeException {
        if (age<18){
            throw new InvalidAgeException("No eligible");
        }else {
            System.out.println("Welcome to Vote");
        }
    }

    public static void main(String[] args) throws InvalidAgeException {
        validate(33);
        System.out.println("Rest of the code");
    }
}
