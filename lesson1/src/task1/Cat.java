package lesson1.task1;

public class Cat implements Action {

    final int LENGTH = 1500;
    final int HEIGHT = 4;

    public boolean run(int pl, int tl) {
        System.out.println("Cat runs");
        boolean result;
        if (pl >= tl) {
            System.out.println("Кот справился и пробежал " + tl + " м.");
            result = true;
        } else {
            System.out.println("Кот не пробежал " + tl + " м.");
            result = false;
        }
        return result;
    }

    public boolean jump(int ph, int wh) {
        System.out.println("Cat jumps");
        boolean result;
        if (ph >= wh) {
            System.out.println("Кот справился и перепрыгнул " + wh + " м.");
            result = true;
        } else {
            System.out.println("Кот не перепрыгнул " + wh + " м.");
            result = false;
        }
        return result;
    }
}
