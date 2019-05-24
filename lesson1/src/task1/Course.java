package lesson1.task1;

public class Course {
    public void courseAction() {
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();


        Treadmill treadmill[] = {
                new Treadmill(500),
                new Treadmill(1000),
                new Treadmill(1500),
                new Treadmill(2000)
        };
        Wall wall[] = {
                new Wall(1),
                new Wall(2),
                new Wall(3),
                new Wall(4)
        };

        int amountHuman = 0;
        int amountCat = 0;
        int amountRobot = 0;

// прохождение препятствий человеком
        for (int i = 0; i < treadmill.length; i++) {
            boolean resultRun = human.run(human.LENGTH, treadmill[i].length);
            if (resultRun == true) {
                amountHuman++;
            } else {
                System.out.println("Человек сходит с дистанции");
                break;
            }
            boolean resultJump = human.jump(human.HEIGHT, wall[i].height);
            if (resultJump == true) {
                amountHuman++;
            } else {
                System.out.println("Человек сходит с дистанции");
                break;
            }
        }
        System.out.println("Человек справился с " + amountHuman + " испытаниями.");
        System.out.println();

        // прохождение препятствий котом
        for (int i = 0; i < treadmill.length; i++) {
            boolean resultRun = cat.run(cat.LENGTH, treadmill[i].length);
            if (resultRun == true) {
                amountCat++;
            } else {
                System.out.println("Кот сходит с дистанции");
                break;
            }
            boolean resultJump = cat.jump(cat.HEIGHT, wall[i].height);
            if (resultJump == true) {
                amountCat++;
            } else {
                System.out.println("Кот сходит с дистанции");
                break;
            }
        }
        System.out.println("Кот справился с " + amountCat + " испытаниями.");
        System.out.println();

// прохождение препятствий роботом
        for (int i = 0; i < treadmill.length; i++) {
            boolean resultRun = robot.run(robot.LENGTH, treadmill[i].length);
            if (resultRun == true) {
                amountRobot++;
            } else {
                System.out.println("Робот сходит с дистанции");
                break;
            }
            boolean resultJump = robot.jump(robot.HEIGHT, wall[i].height);
            if (resultJump == true) {
                amountRobot++;
            } else {
                System.out.println("Робот сходит с дистанции");
                break;
            }
        }
        System.out.println("Робот справился с " + amountRobot + " испытаниями.");
        System.out.println();
    }
}

