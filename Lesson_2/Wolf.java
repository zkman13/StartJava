package Lesson_2;

public class Wolf {

    public String sex;
    public String nickname;
    public int weight;
    public int age;
    public String color;

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
