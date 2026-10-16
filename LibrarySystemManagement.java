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
