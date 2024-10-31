package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String name;
    private int height;
    private int weight;
    private int strength;
    private int speed;
    private int armor;

    public Jaeger() {
    }

    public Jaeger(String name, int height, int weight, int strength, int speed, int armor) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.speed = speed;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void attack() {
        System.out.println(name + " атакует!");
    }

    public void defend() {
        System.out.println(name + " защищается!");
    }
}
