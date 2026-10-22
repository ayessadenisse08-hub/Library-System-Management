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

public static void returnBook() {
        
        // Input member details and book id
        String memberDetails = JOptionPane.showInputDialog(null, "Enter Member Name / Details:", "Return Book", JOptionPane.QUESTION_MESSAGE);
        if (memberDetails == null) return;

        String bookId = JOptionPane.showInputDialog(null, "Enter Book ID:", "Return Book", JOptionPane.QUESTION_MESSAGE);
        if (bookId == null) return;

        boolean found = false;
        for (BookRecord record : records) {
            if (record.bookId.equalsIgnoreCase(bookId.trim()) && record.memberName.equalsIgnoreCase(memberDetails.trim())) {
                found = true;
                if (record.isBorrowed) {
                    // Update book status to available and record the return
                    record.isBorrowed = false;
                    // Show Message "Book Returned Successfully"
                    JOptionPane.showMessageDialog(null, "Book \"Returned Successfully\"", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Notice: This book is already marked as available.", "Notice", JOptionPane.WARNING_MESSAGE);
                }
                break;
            }
        }

        if (!found) {
            // Error message if record combination doesn't match
            JOptionPane.showMessageDialog(null, "Error: No matching borrowed record found for this Member and Book ID.", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
        // Automatically loops back to Main Menu
    }
