package lesson3;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Smith", "79634563287");
        phoneBook.add("Johnson", "79623543213");
        phoneBook.add("Williams", "79776454232");
        phoneBook.add("Jones", "79548538643");
        phoneBook.add("Brown", "79068763542");
        phoneBook.add("Davis", "79096753421");
        phoneBook.add("Miller", "79064673424");
        phoneBook.add("Wilson", "79085437535");
        phoneBook.add("Moore", "79525632686");
        phoneBook.add("Anderson", "79086453423");

        phoneBook.get("Moore");


    }



}
