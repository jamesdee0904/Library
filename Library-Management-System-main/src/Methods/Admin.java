package Methods;

import java.util.Map;
import java.util.Scanner;

public class Admin {
    Scanner sc = new Scanner(System.in);
    private String admin_email = "admin";
    private String password = "admin123";
    private Student student;

    public Admin(Student student) {
        this.student = student;
    }

    public void login() {

        System.out.println("--------- Login Admin ---------");

        System.out.print("Admin Email: ");
        String email = sc.nextLine();
        System.out.print("Admin Password: ");
        String pass = sc.nextLine();

        if (email.equals(admin_email) && pass.equals(password)) {
            while (true) {
                System.out.println("\t[1] Student Login");
                System.out.println("\t[2] Borrowed Book");
                System.out.println("\t[3] Returned Book");
                System.out.println("\t[4] View Available Books");
                System.out.println("\t[5] Add New Book");
                System.out.println("\t[6] Delete Book");
                System.out.println("\t[7] Exit");
                System.out.print("\t\tEnter number: ");
                int num = sc.nextInt();
                sc.nextLine();

                switch (num) {
                    case 1 -> studentLogin();
                    case 2 -> borrowedBook();
                    case 3 -> returnedBook();
                    case 4 -> showAvailableBooks();
                    case 5 -> addNewBook();
                    case 6 -> deleteBook();
                    case 7 -> { return; }
                    default -> System.out.println("Invalid input, re-try.");
                }
            }
        }
    }

    public void addNewBook() {

        System.out.println("----------- ADD NEW BOOK -----------");

        Book defaultBooks = new Book();
        defaultBooks.availableBooks();

        System.out.print("\tEnter Book Title: ");
        String title = sc.nextLine();

        int nextId = Book.book.size() + 1;

        if (Book.book.containsValue(title)) {
            System.out.println("\tThat book already exists in the library.");
        } else {
            Book.book.put(nextId, title);
            System.out.println("----------------------------------------------");
            System.out.println("\t\tSuccessfully added new book:");
            System.out.println("\t\tBook ID: " + nextId);
            System.out.println("\t\tBook Title: " + title);
            System.out.println("----------------------------------------------");
        }
    }

    public void deleteBook() {

        System.out.println("----------- DELETE BOOK -----------");

        if (Book.book.isEmpty()) {
            System.out.println("\t\tNo books available to delete.");
            return;
        }

        System.out.print("\tEnter Book ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (Book.book.containsKey(id)) {
            String removedTitle = Book.book.remove(id);
            System.out.println("----------------------------------------------");
            System.out.println("\t\tSuccessfully deleted:");
            System.out.println("\t\tBook ID: " + id);
            System.out.println("\t\tBook Title: " + removedTitle);
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("\tBook ID not found.");
        }
    }

    public void showAvailableBooks() {

        System.out.println("----------- AVAILABLE BOOKS -----------");

        Book book = new Book();
        book.availableBooks();

        if (Book.book.isEmpty()) {
            System.out.println("\t\tNo available books in the library.");
        } else {
            for (Map.Entry<Integer, String> entry : Book.book.entrySet()) {
                Integer id = entry.getKey();
                String title = entry.getValue();
                System.out.println("\t\tBook ID: " + id);
                System.out.println("\t\tBook Title: " + title);
                System.out.println("----------------------------------------------");
            }
        }
    }

    public void studentLogin() {

        System.out.println("----------- Student Login -----------");

        if (student.user.isEmpty()) {
            System.out.println("\t\tNo Student login yet.");
        } else {
            for (User u : student.user) {
                System.out.println("\t\tStudent Name: " + u.getG_suite());
                System.out.println("\t\tSr-Code: " + u.getSr_code());
                System.out.println("\t\tTime Login: " + u.getLocalTime());
                System.out.println("\t\tDate Login: " + u.getLocalDate());
                System.out.println("----------------------------------------------");
            }
        }
    }

    public void borrowedBook() {

        System.out.println("----------- BORROWED BOOK -----------");

        if (student.borrow.isEmpty()) {
            System.out.println("\tNo borrowed Book yet.");
        } else {
            for (Map.Entry<Integer, String> entry : student.borrow.entrySet()) {
                Integer id = entry.getKey();
                String title = entry.getValue();
                for (User u : student.user) {
                    System.out.println("\t\tStudent Name: " + u.getG_suite());
                    System.out.println("\t\tSr-Code: " + u.getSr_code());
                    System.out.println("\t\tBook ID: " + id);
                    System.out.println("\t\tBook Title: " + title);
                    System.out.println("----------------------------------------------");
                }
            }
        }
    }

    public void returnedBook() {

        System.out.println("----------- RETURNED BOOK -----------");

        if (student.return_book.isEmpty()) {
            System.out.println("\t\tNo book has been return yet.");
            System.out.println("----------------------------------------------");
        } else {
            for (Map.Entry<Integer, String> returned : student.return_book.entrySet()) {
                Integer id = returned.getKey();
                String title = returned.getValue();
                for (User u : student.user) {
                    System.out.println("\t\tStudent Name: " + u.getG_suite());
                    System.out.println("\t\tSr-Code: " + u.getSr_code());
                    System.out.println("\t\tBook ID: " + id);
                    System.out.println("\t\tBook Title: " + title);
                    System.out.println("----------------------------------------------");
                }
            }
        }
    }
}
