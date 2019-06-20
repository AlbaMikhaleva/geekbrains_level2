package lesson3;

import java.util.HashMap;

public class PhoneBook {

    HashMap<String, String> book = new HashMap<>();

    public void add(String name, String number) {
        book.put(name,number);
    }

    public void get (String name){
        System.out.println(book.get(name));
    }


}
