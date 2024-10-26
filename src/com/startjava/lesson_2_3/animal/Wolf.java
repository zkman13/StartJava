package com.startjava.lesson_2_3.animal;

public class Wolf {

    private String sex;
    private String nickname;
    private int weight;
    private int age;
    private String color;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 8) {
            System.out.println("Некорректный возраст");
            return;
        }

        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void howl() {
        System.out.println(nickname + " воет.");
    }

    public void sit() {
        System.out.println(nickname + " сидит.");
    }

    public void walk() {
        System.out.println(nickname + " идёт.");
    }

    public void run() {
        System.out.println(nickname + " бежит.");
    }

    public void hunt() {
        System.out.println(nickname + " охотится.");
    }
}
