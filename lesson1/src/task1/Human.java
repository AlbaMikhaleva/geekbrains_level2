package lesson1.task1;

public class Human implements Action {

    final int LENGTH = 1000;
    final int HEIGHT = 2;

    public boolean run(int pl, int tl) {
        System.out.println("Human runs");
        boolean result;
        if (pl >= tl) {
            System.out.println("Человек справился и пробежал " + tl + " м.");
            result = true;
        } else {
            System.out.println("Человек не пробежал " + tl + " м.");
            result = false;
        }
        return result;
    }

    public boolean jump(int ph, int wh) {
        System.out.println("Human jumps");
        boolean result;
        if (ph >= wh) {
            System.out.println("Человек справился и перепрыгнул " + wh + " м.");
            result = true;
        } else {
                System.out.println("Человек не перепрыгнул " + wh + " м.");
                result = false;
        }
        return result;
    }

}

