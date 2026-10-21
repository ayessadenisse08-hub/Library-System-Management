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

        // Ask for the Book ID
        String inputBookId = JOptionPane.showInputDialog(
            null, "Enter Book ID to borrow:"
        );

        // Check if the input is empty or cancelled
        if (inputBookId == null ||
            inputBookId.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                null, "Invalid Book ID!", "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Search for the Book ID
        for (int i = 0; i < bookCount; i++) {

            if (bIds[i].equalsIgnoreCase(inputBookId.trim())) {

                // Check if the book is available
                if (bkAvailable[i]) {

                    // Ask for the borrower's name
                    String borrower = JOptionPane.showInputDialog(
                        null, "Enter Borrower's Name:"
                    );

                    // Validate borrower's name
                    if (borrower == null ||
                        borrower.trim().isEmpty()) {

                        JOptionPane.showMessageDialog(
                            null, "Invalid Borrower's Name!",
                            "Error", JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }

                    // Update book status and borrower
                    bBorrower[i] = borrower.trim();
                    bkAvailable[i] = false;

                    JOptionPane.showMessageDialog(
                        null,
                        "Book borrowed successfully!\n" +
                        "Book Title: " + bTitles[i] + "\n" +
                        "Author: " + bAuthors[i] + "\n" +
                        "Borrower: " + bBorrower[i],
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    return;

                } else {

                    // Book is already borrowed
                    JOptionPane.showMessageDialog(
                        null, "This book is already borrowed!",
                        "Unavailable", JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            }
        }

        // Book ID was not found
        JOptionPane.showMessageDialog(
            null, "Book ID not found!",
            "Error", JOptionPane.ERROR_MESSAGE
        );
    }
}
