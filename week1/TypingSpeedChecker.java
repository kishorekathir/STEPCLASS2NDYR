import java.util.Scanner;

public class TypingSpeedChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        // Handle potential null inputs
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        // Check if lengths match as specified in the task description
        if (original.length() != typed.length()) {
            System.out.println("Error: The original text and typed text must be of equal length.");
            return;
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        // Traverse the strings character by character
        for (int i = 0; i < totalCharacters; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matchedCharacters++;
            } else {
                // Record the 1-based position of the very first mistake
                if (firstMismatchPosition == -1) {
                    firstMismatchPosition = i + 1;
                }
            }
        }

        // Calculate accuracy percentage
        double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

        // Print formatted output matching the sample format
        System.out.print("Matched: " + matchedCharacters + "/" + totalCharacters + " | ");
        System.out.printf("Accuracy: %.2f%% | ", accuracy);

        if (firstMismatchPosition == -1) {
            System.out.println("No Mismatches");
        } else {
            int index = firstMismatchPosition - 1;
            System.out.println("First Mismatch at position " + firstMismatchPosition + 
                               " ('" + original.charAt(index) + "' vs '" + typed.charAt(index) + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the original passage
        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        // Prompt user for their typed text
        System.out.print("Enter your typed text:  ");
        String typed = scanner.nextLine();

        System.out.println("\n--- Result ---");
        checkTypingAccuracy(original, typed);

        // Close scanner resource
        scanner.close();
    }
}