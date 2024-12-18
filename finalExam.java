import java.util.Scanner;

public class finalExam {
    public static void showMenu() {
        System.out.println("=== LIBRARY MENU ===");
        System.out.println("Menu 1: Show all books");
        System.out.println("Menu 2: Borrow a book");
        System.out.println("Menu 3: Return a book");
        System.out.println("Menu 4: Exit");
        System.out.println();
        System.out.print("Input the menu numbers (1-4): ");
    }

    public static String[][] library() {
        String [][] lib = {
            {"Index", "Titles", "ISBN", "Availability"},
            {"1","Harry Potter","978-3-16-148410-0","Available"},
            {"2","Lord of The Ring","978-1-843-56710-2","Available"},
            {"3","The Alchemist","978-0-06-231500-7","Borrowed"},
            {"4","Sherlock Holmes","978-1-566-19310-3","Available"}
        };
        return lib;
    }

    public static void displayBook(String[][] lib) {
        for (int i = 0; i < lib[0].length; i++) {
            System.out.print(lib[0][i] + "\t" + " | ");
        }
        System.out.println();
        for (int i = 1; i < lib.length; i++) {
            for (int j = 0; j < lib[i].length; j++) {
                System.out.print(lib[i][j] + "\t" + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void borrowBook(Scanner sc, String [][] lib) {
        System.out.println();
        System.out.println("=== BORROW BOOKS MENU ===");
        System.out.print("Enter the book index to borrow: ");
        String enterToBorrow = sc.nextLine();
        
        for (int i = 1; i < lib.length; i++) {
            if (lib[i][0].equals(enterToBorrow)) {
                if (lib[i][3].equalsIgnoreCase("Available")) {
                    lib[i][3] = "Borrowed";
                    System.out.println("You have successfully borrowed: " + lib[i][1]);
                    System.out.println();
                } else {
                    System.out.println("The book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
        System.out.println();
    }

    public static void returnBook(Scanner sc, String [][] lib) {
        System.out.println();
        System.out.println("=== RETURN BOOKS MENU ===");
        System.out.print("Enter the book index to return: ");
        String enterToReturn = sc.nextLine();

        for(int i = 1; i < lib.length; i++) {
            if(lib[i][0].equals(enterToReturn)) {
                if (lib[i][3].equalsIgnoreCase("borrowed")) {
                    lib[i][3] = "available"; 
                    System.out.println("The book index is returned: " + lib[i][1]);
                    System.out.println();
                } 
                else {
                    System.out.println("This book index is not borrowed."); 
                } 
                return; 
            } 
        } 
        System.out.println("Book not found."); 
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] lib = library();
        
        while (true) {
            showMenu();
            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                displayBook(lib);
            } else if (menu == 2) {
                borrowBook(sc,lib);
            } else if (menu == 3) {
                returnBook(sc,lib);
            } else if (menu == 4) {
                System.out.println("Program finished. Thank you!");
                break;
             }
        }
    }
}
