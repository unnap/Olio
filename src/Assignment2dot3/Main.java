package Assignment2dot3;

// Hauska tehtävä!
// kaikki classit nyt omina tiedostoina
// mielellään jäisin hiomaan tätä, mutta kai pitää muitakin tehtäviä tehdä

public class Main {
    public static void main(String[] args){
        boolean juokse = true;

        Library kirjasto = new Library();
        kirjasto.addBook(new Book("Mort", "Terry Pratchett", 1987));
        kirjasto.addBook(new Book("Reaper Man", "Terry Pratchett", 1991));
        kirjasto.addBook(new Book("The Truth", "Terry Pratchett", 2000));
        kirjasto.addBook(new Book("Murder on the Orient Express", "Agatha Christie", 1934));
        kirjasto.addBook(new Book("Nemesis", "Agatha Christie", 1971));
        kirjasto.addBook(new Book("Uzumaki", "Junji Ito", 1999));
        kirjasto.addBook(new Book("Cat Diary", "Junji Ito", 2008));

        kirjasto.addUser("Donald Duck", 92);
        kirjasto.addUser("Daisy Duck", 89);
        kirjasto.addUser("Magica De Spell",65);
        kirjasto.addUser("Gyro Gearloose",70);
        String currentUser = "Donald Duck";

        kirjasto.setRatingsEtc();


        while(juokse) {
            Utili.separator1();
            System.out.println("Welcome to the Library!\n" +
                    "You are logged in as " +currentUser);
            Utili.separator2();
            System.out.println("1) Display books in the collection\n" +
                    "2) Search by author\n" +
                    "3) Search by title & Borrow\n" +
                    "4) Return books\n" +
                    "5) Log in\n" +
                    "6) Add user\n" +
                    "7) Exit\n");

            // tää on ainoo kohta missä on intcheck kun tää on kopsattu muista tehtävistä
            // jätän intcheckin pois muista valinnoista et en käytä liikaa aikaa tähän
            // eli käyttäjä varo!
            if (Utili.checkInt()) {
                int choice = Utili.getScanner().nextInt();

                switch(choice) {
                    // tulostetaan kirjaston hyllyssä oleva kokoelma
                    case 1:
                        kirjasto.displayBooks();
                        System.out.printf("\nAverage rating of the books in the collection: %.1f" +
                                        "\nThe book with most reviews is %s\n",
                                kirjasto.getAverageBookRating(), kirjasto.getMostReviewedBook().getTitle());
                        break;

                    // haetaan tekijän nimen perusteella
                    // pitää kirjoittaa koko nimi
                    case 2:
                        Utili.getScanner().nextLine();
                        System.out.println("Enter author's full name");
                        String authorName = Utili.getScanner().nextLine();
                        kirjasto.findBooksByAuthor(authorName);
                        break;

                    // kirjan haku nimellä ja lainaus
                    case 3:
                        Utili.getScanner().nextLine();
                        System.out.println("Enter book title");
                        String bookTitle = Utili.getScanner().nextLine();

                        if(kirjasto.isBookAvailable(bookTitle)){
                            System.out.println(bookTitle+" is available in the collection");
                            Utili.separator2();
                            kirjasto.getBook(bookTitle);
                            System.out.println("Borrow?\n1) Yes\n2) No"); // tuo 2) on vale

                            if(Utili.getScanner().nextInt()==1){
                                kirjasto.borrowBook(bookTitle,currentUser);
                            }
                        }else{
                            System.out.println("Book not found");
                        }
                        break;

                    // näyttää käyttäjän lainat
                    // voi myös palauttaa
                    case 4:
                        if(kirjasto.hasBorrows(currentUser)){
                            kirjasto.displayUserBorrows(currentUser);
                            Utili.separator2();
                            System.out.println("Do you want to return your books?\n1) Yes\n2) No");
                            if(Utili.getScanner().nextInt()==1){
                                kirjasto.returnBook(currentUser);
                            }
                        } else {
                            System.out.println("No borrows");
                        }
                        break;

                    // listaa käyttäjät
                    // voit myös vaihtaa käyttäjän
                    case 5:
                        kirjasto.displayUsers();
                        Utili.separator2();
                        Utili.getScanner().nextLine();
                        System.out.println("Enter user number to log in");
                        currentUser= kirjasto.logIn(Utili.getScanner().nextInt());
                        break;

                    // voit lisätä oman käyttäjätunnuksen jos et haluu olla ankkalinnalainen
                    case 6:
                        Utili.getScanner().nextLine();
                        System.out.println("Enter name");
                        String userName = Utili.getScanner().nextLine();
                        System.out.println("Enter age");
                        int age = Utili.getScanner().nextInt();
                        kirjasto.addUser(userName,age);
                        break;
                    case 7:
                        System.out.println("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.println("No such task");
                }
                Utili.getScanner().nextLine();
                Utili.separator2();
                Utili.cont();
                Utili.getScanner().nextLine();
            }
        }
    }
}
