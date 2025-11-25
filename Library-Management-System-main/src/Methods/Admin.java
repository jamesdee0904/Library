package Methods;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Account{
    Scanner sc = new Scanner(System.in);
    private String admin_email = "Admin123";
    private String password = "AdminPassword";
    private Student student;
    private HashMap<Integer, String> book = new HashMap<>();

    public Admin(Student student) {
        this.student = student;
    }
    @Override
    public void login() {
        System.out.print("Admin Email: ");
        String email = sc.nextLine();
        System.out.print("Admin Password: ");
        String pass = sc.nextLine();
        if (email.equals(admin_email) && pass.equals(password)) {
            while (true) {
                System.out.println("\t[1] Student Login\n\t[2] Borrowed Book\n\t[3] Returned Book\n\t[4] Add Account\n\t[5] Exit");
                System.out.print("\t\tEnter number: ");
                int num = sc.nextInt();
                if (num == 1) {
                    studentLogin();
                } else if (num == 2) {
                    borrowedBook();
                } else if (num == 3) {
                    returnedBook();
                } else if (num == 4) {
                    //add account
                } else if(num == 5){
                    break;
                }else {
                    System.out.println("Invalid input, re-try.");
                }
            }
        }else {
            System.out.println("Invalid input, re-try.");
        }
    }
    public void studentLogin() {
        if (student.user.isEmpty()) {
            System.out.println("\t\tNo Student login yet.");
        } else {
            for (User u : student.user) {
                System.out.println("\t\tStudent Name: " + u.getG_suite());
                System.out.println("\t\tSr-Code: " + u.getSr_code());
                System.out.println("\t\tTime Login: " + u.getLocalTime());
                System.out.println("\t\tDate Login: " + u.getLocalDate());
                System.out.println(" - ".repeat(22));
            }
        }
    }
    public void borrowedBook() {
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
                    System.out.println(" - ".repeat(22));
                }
            }
        }
    }
    public void returnedBook(){
        if (student.return_book.isEmpty()){
            System.out.println("\t\tNo book has been return yet.");
            System.out.println(" - ".repeat(22));
        }else {
            for (Map.Entry<Integer, String> returned : student.return_book.entrySet()) {
                Integer id = returned.getKey();
                String title = returned.getValue();
                for (User u : student.user) {
                    System.out.println("\t\tStudent Name: " + u.getG_suite());
                    System.out.println("\t\tSr-Code: " + u.getSr_code());
                    System.out.println("\t\tBook ID: " + id);
                    System.out.println("\t\tBook Title: " + title);
                    System.out.println(" - ".repeat(22));
                }
            }
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
    public void showBooks(){
        for (Map.Entry<Integer, String> entry : book.entrySet()){
            Integer id = entry.getKey();
            String title = entry.getValue();
            System.out.println("\tID: " + id + " Title: " + title);
        }
    }
}
