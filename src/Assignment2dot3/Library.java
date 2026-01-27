package Assignment2dot3;

import java.util.ArrayList;

// book Book books book Book
public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    void addBook(Book book){
        books.add(book);
    }

    void addUser(String name, int age){
        users.add(new User(name, age));
    }

    String logIn(int j){
        String who = "null";
        for(int i=0;i<users.size();i++){
            if(i==j-1){
                who=users.get(j-1).getName();
                break;
            }
        }
        System.out.println("You're now logged in as "+who);
        return who;
    }

    void print(Book book, int i){
        System.out.printf("\n%d) \"%s\", Author: \"%s\", Publication year: %d",
                i,book.getTitle(),book.getAuthor(),book.getYear());
    }

    void displayBooks(){
        Utili.separator1();
        System.out.println("Books in the collection");
        int i = 1;
        for(Book book : books){
            print(book, i++);
        }
        System.out.println();
    }

    void findBooksByAuthor(String author){
        boolean found = false;
        Utili.separator1();
        System.out.printf("Books by \"%s\"\n",author);
        int i=1;
        for(Book book:books){
            if(book.getAuthor().equalsIgnoreCase(author)){
                print(book, i++);
                if(!found){
                    found=true;
                }
            }
        }
        if(!found){
            System.out.println("No books found");
        }
        System.out.println();
    }

    boolean isBookAvailable(String title){
        boolean available = false;
        for(Book book : books) {
        if(book.getTitle().equalsIgnoreCase(title)){
            available=true;
            break;
            }
        }
        return available;
    }

    void borrowBook(String title, String userName){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                books.remove(book);
                for(User user : users){
                    if(user.getName().equalsIgnoreCase(userName)){
                        user.borrowBook(book);
                        System.out.println("Book borrowed");
                        break;
                    }
                }
                break;
            }
        }
    }

    void returnBook(String currentUser){
        for(User user : users){
            if(user.getName().equalsIgnoreCase(currentUser)){
                while(user.hasBorrows()){
                    books.add(user.returnBooks());
                }
                System.out.println("Books returned");
                break;
            }
        }
    }

    double getAverageBookRating(){
        double sum = 0;
        for(Book book : books){
            sum+=book.getRating();
        }
        return sum/books.size();
    }

    Book getMostReviewedBook(){
        Book best = books.get(0);
        for(Book book : books){
            if(book.reviewAmount()>best.reviewAmount()){
                best=book;
            }
        }
        return best;
    }

    void displayUsers(){
        int i=1;
        for(User user : users){
            System.out.println(i+++") Name: "+user.getName()+", Age: "+user.getAge());
            if(user.hasBorrows()){
                user.displayBorrowed();
            }
        }
    }

    boolean hasBorrows(String name){
        boolean has = false;
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                has = user.hasBorrows();
                break;
            }
        }
        return has;
    }

    void displayUserBorrows(String name){
        for(User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                user.displayBorrowed();
            }
        }
    }

void setRatingsEtc(){
        for(Book book : books) {
            // erikoiskohtelu iton kissapäiväkirjalle
            // ihan vaan että yhdellä kirjalla olisi eniten arvosteluja
            // kun käyttäjiä on niin vähän
            // sangatsu manga kääntäkää iton kissapäiväkirja suomeksi
            // ivrea saa pysyä kaukana tästä teoksesta
            if (book.getTitle().equals("Cat Diary")) {
                book.setRating(100);
                for (User user : users) {
                    book.addReview(user.getName() + ": Best book");
                }
                book.addReview("God: Best book");
            } else{
                book.setRating((Math.random() * 4) + 1);

                for (User user : users) {
                    // arvotaan antaako käyttäjä arvostelun
                    if (Utili.randomi()) {
                        //arvotaan onko arvostelu positiivinen
                        if (Utili.randomi()) {
                            book.addReview(user.getName() + ": Good book");
                        } else {
                            book.addReview((user.getName() + ": Sucks"));
                        }
                    }
                }
            }
        }
    }


void getBook(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book.getTitle() +
                        "\nAuthor: "+book.getAuthor() +
                        "\nYear: "+book.getYear());
                Utili.separator2();
                System.out.printf("Rating: %.1f\n",book.getRating());
                System.out.println("Reviews:");
                book.displayReviews();
                Utili.separator2();
                break;
            }
        }
    }
}
