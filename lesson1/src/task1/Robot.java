package lesson1.task1;

public class Robot implements Action{

    final int LENGTH = 2000;
    final int HEIGHT = 1;

    public boolean run(int pl, int tl) {
        System.out.println("Robot runs");
        boolean result;
        if (pl >= tl) {
            System.out.println("Робот справился и пробежал " + tl + " м.");
            result = true;
        } else {
            System.out.println("Робот не пробежал " + tl + " м.");
            result = false;
        }
        return result;
    }

    public boolean jump(int ph, int wh) {
        System.out.println("Robot jumps");
        boolean result;
        if (ph >= wh) {
            System.out.println("Робот справился и перепрыгнул " + wh + " м.");
            result = true;
        } else {
            System.out.println("Робот не перепрыгнул " + wh + " м.");
            result = false;
        }
        return result;
    }
}
