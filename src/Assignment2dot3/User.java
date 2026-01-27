package Assignment2dot3;

import java.util.ArrayList;

public class User {
    private final String name;
    private final int age;
    private ArrayList<Book> borrowed = new ArrayList<>();

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    String getName(){
        return name;
    }

    int getAge(){
        return age;
    }

    void borrowBook(Book book){
        borrowed.add(book);
    }

    boolean hasBorrows(){
        return borrowed.size()>0;
    }

    Book returnBooks(){
        Book book = borrowed.get(0);
        borrowed.remove(0);
        return book;
    }

    void displayBorrowed(){
        System.out.println("Borrowed books:");
        for(Book book : borrowed){
            System.out.println(book.getTitle());
        }
    }
}
