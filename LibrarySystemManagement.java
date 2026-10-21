package Finals1stSem;

import javax.swing.JOptionPane;

public class LibrarySystemManagement {

    static final int MAX = 100;
    static String[] bIds = new String[MAX];
    static String[] bTitles = new String[MAX];
    static String[] bAuthors = new String[MAX];
    static boolean[] bkAvailable = new boolean[MAX];
    static String[] bBorrower = new String[MAX];   
    static int bookCount = 0;

    public static void main(String[] args) {
        String inputBookId = JOptionPane.showInputDialog(null, "Enter Book ID:");
        String inputBookTitle = JOptionPane.showInputDialog(null, "Enter Book Title:");
        String inputBookAuthor = JOptionPane.showInputDialog(null, "Enter Book Author:");

        if (inputBookId == null || inputBookId.trim().isEmpty() ||
            inputBookTitle == null || inputBookTitle.trim().isEmpty() ||
            inputBookAuthor == null || inputBookAuthor.trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(null, "Validation Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            bIds[bookCount] = inputBookId;
            bTitles[bookCount] = inputBookTitle;
            bAuthors[bookCount] = inputBookAuthor;
            bkAvailable[bookCount] = true;
            bookCount++;

            JOptionPane.showMessageDialog(null, "Record added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
// borrow book
public static void borrowBook() {

    boolean borrowing = true;

    while (borrowing) {

        // INPUT MEMBER DETAILS
        String memberName = JOptionPane.showInputDialog(
            null, "Enter Member Name:"
        );

        if (memberName == null || memberName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "Invalid Member Name!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // INPUT BOOK ID
        String inputBookId = JOptionPane.showInputDialog(
            null, "Enter Book ID to borrow:"
        );

        if (inputBookId == null || inputBookId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "Invalid Book ID!",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean found = false;
        boolean borrowed = false;

        // SEARCH FOR BOOK ID
        for (int i = 0; i < bookCount; i++) {

            if (bIds[i].equalsIgnoreCase(inputBookId.trim())) {

                found = true;

                // CHECK BOOK AVAILABILITY
                if (bkAvailable[i]) {

                    // INPUT BORROWER DETAILS
                    bBorrower[i] = memberName.trim();

                    // UPDATE BOOK STATUS
                    bkAvailable[i] = false;

                    borrowed = true;

                    // DISPLAY SUCCESS MESSAGE
                    JOptionPane.showMessageDialog(
                        null,
                        "Book Borrowed Successfully!\n\n" +
                        "Member Name: " + bBorrower[i] + "\n" +
                        "Book ID: " + bIds[i] + "\n" +
                        "Book Title: " + bTitles[i] + "\n" +
                        "Author: " + bAuthors[i],
                        "Borrowing Successful",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                } else {

                    // BOOK IS ALREADY BORROWED
                    JOptionPane.showMessageDialog(
                        null,
                        "No Book Available!\n" +
                        "This book is already borrowed.",
                        "Unavailable",
                        JOptionPane.WARNING_MESSAGE);
                }

                break;
            }
        }

        // BOOK ID NOT FOUND
        if (!found) {
            JOptionPane.showMessageDialog(null,"Book ID not found!","Error",JOptionPane.ERROR_MESSAGE);
        }

        // ASK TO BORROW ANOTHER BOOK
        int option = JOptionPane.showConfirmDialog(null,borrowed? "Do you want to borrow another book?": "Do you want to try again?","Borrow Books",JOptionPane.YES_NO_OPTION);

        if (option != JOptionPane.YES_OPTION) {
            borrowing = false;
        }
    }

    // RETURN TO MAIN MENU
    JOptionPane.showMessageDialog( null,  "Returning to Main Menu...", "Library Management System",JOptionPane.INFORMATION_MESSAGe );
}
