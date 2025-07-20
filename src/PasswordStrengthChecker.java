import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int score = 0;

        // Check length
        if (password.length() >= 8) {
            score++;
        } else {
            System.out.println(" Password should be at least 8 characters long.");
        }

        // Check for uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score++;
        } else {
            System.out.println("Include at least one uppercase letter (A-Z).");
        }

        // Check for lowercase letters
        if (password.matches(".*[a-z].*")) {
            score++;
        } else {
            System.out.println(" Include at least one lowercase letter (a-z).");
        }

        // Check for digits
        if (password.matches(".*[0-9].*")) {
            score++;
        } else {
            System.out.println("Include at least one digit (0-9).");
        }

        // Check for special characters
        if (password.matches(".*[!@#$%^&*()_+=<>?/{}\\[\\]-].*")) {
            score++;
        } else {
            System.out.println(" Include at least one special character (!@#$...).");
        }

        // Final feedback
        System.out.print("\nPassword strength: ");
        switch (score) {
            case 5:
                System.out.println(" Very Strong");
                break;
            case 4:
                System.out.println(" Strong");
                break;
            case 3:
                System.out.println(" Medium");
                break;
            case 2:
                System.out.println(" Weak");
                break;
            default:
                System.out.println(" Very Weak");
                break;
        }
    }
}

