import java.util.Scanner;

public class SingleStudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for student's score
        System.out.print("Enter student's score (0-100): ");
        int score = scanner.nextInt();
        
        // Validate input
        if (score < 0 || score > 100) {
            System.out.println("Invalid score! Please enter between 0 and 100.");
            return;
        }
        
        // Determine grade and remark using if-else-if statements
        int grade;
        String remark;
        
        if (score >= 80) {
            grade = 1;
            remark = "Distinction";
        } else if (score >= 75) {
            grade = 2;
            remark = "Distinction";
        } else if (score >= 66) {
            grade = 3;
            remark = "Credit";
        } else if (score >= 60) {
            grade = 4;
            remark = "Credit";
        } else if (score >= 50) {
            grade = 5;
            remark = "Credit";
        } else if (score >= 45) {
            grade = 6;
            remark = "Credit";
        } else if (score >= 35) {
            grade = 7;
            remark = "Pass";
        } else if (score >= 30) {
            grade = 8;
            remark = "Pass";
        } else {
            grade = 9;
            remark = "Fail";
        }
        
        // Display the results
        System.out.println("\n=== STUDENT RESULT ===");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Remark: " + remark);
        
        scanner.close();
    }
}
