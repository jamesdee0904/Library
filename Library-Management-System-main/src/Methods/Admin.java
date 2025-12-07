package Methods;

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
        book();
        accounts();
    }
    @Override
    public void login() {
        System.out.print("Admin Email: ");
        String email = sc.nextLine();
        System.out.print("Admin Password: ");
        String pass = sc.nextLine();
        if (email.equals(admin_email) && pass.equals(password)) {
            while (true) {
                System.out.println("\t[1] Student Login\n\t[2] Borrowed Book\n\t[3] Returned Book\n\t[4] Add Account\n\t[5] Book Management\n\t[6] Exit");
                System.out.print("\t\tEnter number: ");
                int num = sc.nextInt();
                if (num == 1) {
                    studentLogin();
                } else if (num == 2) {
                    borrowedBook();
                } else if (num == 3) {
                    returnedBook();
                } else if (num == 4) {
                    accountMenu();
                } else if(num == 5){
                    bookMenu();
                } else if(num == 6){
                    break;
                } else {
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
        System.out.println(" - ".repeat(22));
        for (Map.Entry<Integer, String> entry : book.entrySet()){
            Integer id = entry.getKey();
            String title = entry.getValue();
            System.out.println("\tID: " + id + " Title: " + title);
        }
    }

public void bookMenu() {
    while (true) {
        System.out.println(" - ".repeat(22));
        System.out.println("\t[1] Show Books");
        System.out.println("\t[2] Add Book");
        System.out.println("\t[3] Edit Book");
        System.out.println("\t[4] Delete Book");
        System.out.println("\t[5] Back");
        System.out.print("\t\tEnter number: ");
        int select = sc.nextInt();

        if (select == 1) {
            showBooks();
        } else if (select == 2) {
            addBook();
        } else if (select == 3) {
            editBook();
        } else if (select == 4) {
            deleteBook();
        } else if (select == 5) {
            break;
        } else {
            System.out.println(" - ".repeat(22));
            System.out.println("\t\tInvalid input.");
        }
    }
}

public void addBook() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter New Book ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    if (book.containsKey(id)) {
        System.out.println(" - ".repeat(22));
        System.out.println("\tBook ID already exists. Please use another ID.");
        return;  // stop here
    }

    System.out.print("\tEnter Book Title: ");
    String title = sc.nextLine();

    book.put(id, title);
    System.out.println(" - ".repeat(22));
    System.out.println("\tBook Added Successfully!");
}

public void editBook() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter Book ID to Edit: ");
    int id = sc.nextInt();
    sc.nextLine();

    if (book.containsKey(id)) {
        System.out.print("\tEnter New Title: ");
        String newTitle = sc.nextLine();
        book.put(id, newTitle);
        System.out.println("\tBook Updated Successfully!");
    } else {
        System.out.println(" - ".repeat(22));
        System.out.println("\tBook ID Not Found.");
    }
}

public void deleteBook() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter Book ID to Delete: ");
    int id = sc.nextInt();

    if (book.containsKey(id)) {
        book.remove(id);
        System.out.println("\tBook Deleted Successfully!");
    } else {
        System.out.println(" - ".repeat(22));
        System.out.println("\tBook ID Not Found.");
    }
}


@Override
public void accountMenu() {
    while (true) {
        System.out.println(" - ".repeat(22));
        System.out.println("\t[1] Show Accounts");
        System.out.println("\t[2] Add Account");
        System.out.println("\t[3] Edit Account and Password");
        System.out.println("\t[4] Delete Account");
        System.out.println("\t[5] Back");
        System.out.print("\tEnter number: ");

        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            showAccounts();
        } else if (option == 2) {
            addAccount();
        } else if (option == 3) {
            editAccount();
        } else if (option == 4) {
            deleteAccount();
        } else if (option == 5) {
            break;
        } else {
            System.out.println("\tInvalid Input.");
        }
    }
}

public void showAccounts() {
    if (account.isEmpty()) {
        System.out.println("\tNo accounts available.");
        return;
    }

    System.out.println(" - ".repeat(22));
    for (String email : account.keySet()) {
        System.out.println("\tEmail: " + email + " | Password: " + account.get(email));
    }
}

public void addAccount() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter Email: ");
    String email = sc.nextLine();

    if (account.containsKey(email)) {
        System.out.println("\tAccount already exists.");
        return;
    }

    System.out.print("\tEnter Password: ");
    String pass = sc.nextLine();

    account.put(email, pass);
    System.out.println("\tAccount Added Successfully!");
}

public void editAccount() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter Email to Edit: ");
    String email = sc.nextLine();

    if (!account.containsKey(email)) {
        System.out.println("\tAccount not found.");
        return;
    }

    System.out.print("\tEnter New Password: ");
    String newPass = sc.nextLine();

    account.put(email, newPass);
    System.out.println("\tPassword Updated!");
}

public void deleteAccount() {
    System.out.println(" - ".repeat(22));
    System.out.print("\tEnter Email to Delete: ");
    String email = sc.nextLine();

    if (!account.containsKey(email)) {
        System.out.println("\tAccount not found.");
        return;
    }

    account.remove(email);
    System.out.println("\tAccount Deleted Successfully!");
    }
}


