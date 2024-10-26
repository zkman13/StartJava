package com.startjava.lesson_2_3.robot;

public class JaegerTest {

    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger();
        gipsyDanger.setName("Gipsy Danger");
        gipsyDanger.setHeight(260);
        gipsyDanger.setWeight(1980);
        gipsyDanger.setSpeed(7);
        gipsyDanger.setStrength(8);
        gipsyDanger.setArmor(6);

        System.out.println(gipsyDanger.getName());
        System.out.println(gipsyDanger.getHeight());
        System.out.println(gipsyDanger.getWeight());
        System.out.println(gipsyDanger.getSpeed());
        System.out.println(gipsyDanger.getStrength());
        System.out.println(gipsyDanger.getArmor());
        gipsyDanger.attack();
        gipsyDanger.defend();

        System.out.println();

        Jaeger strikerEureka = new Jaeger("Striker Eureka", 250, 6650,
                10, 10, 9);

        System.out.println(strikerEureka.getName());
        System.out.println(strikerEureka.getHeight());
        System.out.println(strikerEureka.getWeight());
        System.out.println(strikerEureka.getSpeed());
        System.out.println(strikerEureka.getStrength());
        System.out.println(strikerEureka.getArmor());
        strikerEureka.attack();
        strikerEureka.defend();
    }
}
