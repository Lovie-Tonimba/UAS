import java.util.Scanner;
public class finalExam244107060101 {
    public static void main(String[] args) {
        mainMenu();
    }
    static void mainMenu(){
    Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.println("=== WELCOME TO THE LIBRARY ===");
            System.out.println("1. Display Available Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a New Book");
            System.out.println("5. Exit");
            System.out.print("Select menu: ");
            select = sc.nextInt();
            
            if(select == 1){
                displayBooks();
            }else if(select == 2){
                borrowBook();
            }else if(select == 3){
                returnBook();
            }else if(select == 4){
                addNewBook();
            }else if(select == 5){
                System.out.println("Thank you for visiting our library, see you later!");
                break;
            }else{
                System.out.println("Select one menu on the following list. Try again.\n");
            }
        }
    }

    static String [] book ={"Harry Potter", "Lord of The Ring", "The Alchemist", "Sherlock Holmes"};
    static String [] isbn ={"978-3-16-148410-0", "978-1-843-56710-2", "978-0-06-231500-7", "978-1-566-19310-3"};
    static boolean [] available = {true, true, true, true};
    static int select;

    static void displayBooks(){
        System.out.println("=== DISPLAY AVAILABLE BOOKS ===");
        System.out.printf("%-5s %-20s %-25s %-10s%n", "Index", "Title", "ISBN", "Availability");
        for (int i = 0; i < book.length; i++) {
            if(available[i]){
                String availability = "Available";
                System.out.printf("%-5d %-20s %-25s %-10s%n", (i + 1), book[i], isbn[i], availability);
            }else{
                String availability = "Borrowed";
                System.out.printf("%-5d %-20s %-25s %-10s%n", (i + 1), book[i], isbn[i], availability);
            }
        }
        System.out.println();
    }

    static void borrowBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("=== BORROW A BOOK ===");
        while (true) { 
            System.out.print("Input index of the book you want to borrow: ");
            int index = sc.nextInt() - 1;
            if(index >= 0 && index < book.length){
                if(available[index]){
                    available[index] = false;
                    System.out.println("Thankyou for borrowed " + book[index]);
                    break;
                }else{
                    System.out.println("Sorry this book is currently borrowed, please select another book.");
                }
            }else{
                System.out.println("This book index is not available. Try again.");
            }
        }
    }

    static void returnBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("=== RETURN A BOOK ===");
        while (true) { 
            System.out.print("Input index of the book you want to return: ");
            int index = sc.nextInt() - 1;
            if (index >= 0 && index < book.length) {
                if (!available[index]) {
                    available[index] = true; 
                    System.out.println("Thankyou for returned " + book[index]);
                    break;
                } else {
                    System.out.println("This book was not borrowed.");
                }
            } else {
                System.out.println("This book index is not available. Try again.");
            }
            System.out.println();
        }
    }

    static void addNewBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
    
        System.out.println("=== ADD A NEW BOOK ===");
        System.out.print("Input the title of the new book: ");
        String newBookTitle = sc.nextLine();
        System.out.print("Input the ISBN of the new book: ");
        String newBookISBN = sc.nextLine();
    
        String[] newBook = new String[book.length + 1];
        String[] newIsbn = new String[isbn.length + 1];
        boolean[] newAvailable = new boolean[available.length + 1];
    
        for (int i = 0; i < book.length; i++) {
            newBook[i] = book[i];
            newIsbn[i] = isbn[i];
            newAvailable[i] = available[i];
        }

        newBook[book.length] = newBookTitle;
        newIsbn[isbn.length] = newBookISBN;
        newAvailable[available.length] = true; 

        book = newBook;
        isbn = newIsbn;
        available = newAvailable;

        System.out.println("New book added successfully: " + newBookTitle);
        System.out.println();
    }
}