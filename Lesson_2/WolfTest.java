package Lesson_2;

public class WolfTest {
    public static void main(String[] args) {

        Wolf wolf = new Wolf();

        wolf.sex = "Самец";
        wolf.nickname = "Гроза кроликов";
        wolf.weight = 30;
        wolf.age = 5;
        wolf.color = "Серый";

        System.out.println("Пол: " + wolf.sex);
        System.out.println("Кличка: " + wolf.nickname);
        System.out.println("Вес: " + wolf.weight + " кг");
        System.out.println("Возраст: " + wolf.age + " лет");
        System.out.println("Окрас: " + wolf.color);

        wolf.howl();
        wolf.sit();
        wolf.walk();
        wolf.run();
        wolf.hunt();
    }
}
