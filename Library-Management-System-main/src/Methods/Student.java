package Methods;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student extends Account {
    private Scanner sc = new Scanner(System.in);
    ArrayList<User> user = new ArrayList<>();
    private HashMap<Integer, String> book = new HashMap<>();
    HashMap<Integer, String> borrow = new HashMap<>();
    HashMap<Integer, String> return_book = new HashMap<>();

    @Override
    public void login() {
        System.out.println(" - ".repeat(7) + " Student Login " + (" - ".repeat(7)));
        System.out.print("\tEnter G-Suite: ");
        String g_suite = sc.nextLine();
        System.out.print("\tSr-Code: ");
        String sr_code = sc.nextLine();
        accounts();
        boolean validLogin = false;
        for (Map.Entry<String, String> acc : account.entrySet()) {
            String gsuite = acc.getKey();
            String srcode = acc.getValue();
            if (gsuite.equals(g_suite) && srcode.equals(sr_code)) {
                validLogin = true;
                LocalTime localTime = LocalTime.now();
                LocalDate localDate = LocalDate.now();
                User newLogin = new User(g_suite, sr_code, localTime, localDate);
                user.add(newLogin);
                System.out.println();
                while (true) {
                    System.out.println("[1] Borrow Book\n[2] Return Book\n[3] Exit");
                    System.out.print("Enter number: ");
                    int enter = sc.nextInt();
                    sc.nextLine(); 
                    if (enter == 1) {
                        borrowBook();
                    } else if (enter == 2) {
                        returnBook();
                    } else if (enter == 3) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
                break;
            }
        }
        if (!validLogin) {
            System.out.println("Invalid G-Suite or Sr-Code. Login failed.");
        }
    }

    @Override
    public void book() {
        book.put(1, "Computer Programming");
        book.put(2, "Advance Computer Programming");
        book.put(3, "Database Management");
        book.put(4, "Networking 1");
        book.put(5, "Physics-Calculus");
        book.put(6, "Discrete Mathematics");
    }

    public void showBook() {
        for (Map.Entry<Integer, String> entry : book.entrySet()) {
            Integer id = entry.getKey();
            String title = entry.getValue();
            System.out.println("\tID: " + id + " Title: " + title);
        }
    }

    public void borrowBook() {
        book();
        showBook();
        System.out.print("\t\tBook id: ");
        int book_id = sc.nextInt();
        sc.nextLine(); // consume newline
        if (book.containsKey(book_id)) {
            String title = book.get(book_id);
            borrow.put(book_id, title);
            System.out.println(" - ".repeat(22));
            System.out.println("\t\t Successfully borrowed title: " + title);
            System.out.println(" - ".repeat(22));
        } else {
            System.out.println("No book id like that.");
        }
    }

    public void returnBook() {
        if (borrow.isEmpty()) {
            System.out.println("No book to return yet.");
        } else {
            for (Map.Entry<Integer, String> returnbook : borrow.entrySet()) {
                Integer id = returnbook.getKey();
                String title = returnbook.getValue();
                System.out.println("\tID: " + id + " Title: " + title);
            }
            System.out.print("\t\tReturn Book id: ");
            int bookID = sc.nextInt();
            sc.nextLine(); 
            if (borrow.containsKey(bookID)) {
                String title = borrow.get(bookID);
                return_book.put(bookID, title);
                borrow.remove(bookID);
                System.out.println(" - ".repeat(22));
                System.out.println("\t\t Successfully returned the book: " + title);
                System.out.println(" - ".repeat(22));
            } else {
                System.out.println("Invalid book ID.");
            }
        }
    }

    @Override
    public void accountMenu() {
        System.out.println("Student cannot access account management menu.");
    }
}
