package lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"2", "3", "7", "5"},
                {"2", "3", "7", "5"},
                {"2", "3", "7", "5"},
                {"2", "3", "7", "5"}};
        try {
            summa(arr);

        } catch (MyArraySizeException e) {
            System.out.println("Задали массив другого размера");
        } catch (MyArrayDataException e) {
            e.printStackTrace();}
        }

    static void summa(String arr[][]) throws MyArraySizeException, MyArrayDataException {

        int rows = arr.length;
        int columbs = arr[0].length;
        int[][] arr2 = new int[rows][columbs];
        int sum = 0;
        int x = 0;
        int y = 0;

        if ((rows != 4) || (columbs != 4)) throw new MyArraySizeException("Задали массив другого размера");
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columbs; j++) {
                    x = i;
                    y = j;
                    arr2[i][j] = Integer.parseInt(arr[i][j]);
                    sum += arr2[i][j];
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке не число. Адрес ячейки: ", x, y);
        }


        System.out.println(sum);
    }
}

