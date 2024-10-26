package com.startjava.lesson_2_3.person;

public class Person {

    private String sex = "Male";
    private String name = "Slacker";
    private int height = 168;
    private int weight = 70;
    private int age = 35;

    public void walk() {
        System.out.println(name + " идёт.");
    }

    public void sit() {
        System.out.println(name + " сидит.");
    }

    public void run() {
        System.out.println(name + " бежит.");
    }

    public void talk() {
        System.out.println(name + " говорит.");
    }

    public void learnJava() {
        System.out.println(name + " учит Java.");
    }
}
