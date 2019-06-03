package lesson3;


import java.util.*;


public class Array {
    public static void main(String args[]) {
        ArrayList<String> words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("mouse");
        words.add("cat");
        words.add("monkey");
        words.add("horse");
        words.add("bear");
        words.add("dog");
        words.add("tiger");
        words.add("bird");
        words.add("lion");
        words.add("duck");
        words.add("fish");
        words.add("lion");
        words.add("cat");

        Set<String> wordsUnique = new HashSet(words);
        System.out.println("Список уникальных слов: " + wordsUnique);
        System.out.println();

        Iterator<String> iter = wordsUnique.iterator();
        int[] sum = new int[wordsUnique.size()];
        for (int i = 0; i < wordsUnique.size(); i++) {
            String wrd = iter.next();
            sum[i] = 0;
            for (int j = 0; j < words.size(); j++) {
                String wrd2 = words.get(j);
                if (wrd.equals(wrd2)) {
                    sum[i] = sum[i] + 1;
                }
            }
            System.out.println("Слово " + wrd + " встречается " + sum[i] + " раз.");
        }
    }

}

