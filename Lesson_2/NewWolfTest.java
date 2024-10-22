package Lesson_2;

public class NewWolfTest {
    public static void main(String[] args) {
        NewWolf wolf = new NewWolf();

        wolf.setSex("Самец");
        wolf.setNickname("Гроза кроликов");
        wolf.setWeight(30);
        wolf.setAge(5);
        wolf.setColor("Серый");

        System.out.println("Пол: " + wolf.getSex());
        System.out.println("Имя: " + wolf.getNickname());
        System.out.println("Вес: " + wolf.getWeight());
        System.out.println("Возраст: " + wolf.getAge());
        System.out.println("Цвет: " + wolf.getColor());

        wolf.howl();
        wolf.sit();
        wolf.walk();
        wolf.run();
        wolf.hunt();
    }
}
