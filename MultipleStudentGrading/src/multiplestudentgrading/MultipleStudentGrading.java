import java.util.Scanner;

public class MultipleStudentGrading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to store count for each grade (1-9)
        int[] gradeCount = new int[10]; // Indices 0-9, we use 1-9
        int studentCount = 1;
        final int TOTAL_STUDENTS = 5;
        
        System.out.println("=== BUKOTO COMPREHENSIVE SCHOOL GRADING SYSTEM ===");
        System.out.println("Enter scores for " + TOTAL_STUDENTS + " students:\n");
        
        // Process 5 students using a while loop
        while (studentCount <= TOTAL_STUDENTS) {
            System.out.print("Enter score for Student " + studentCount + " (0-100): ");
            int score = scanner.nextInt();
            
            // Validate input
            if (score < 0 || score > 100) {
                System.out.println("Invalid score! Please enter between 0 and 100.");
                continue; // Skip the rest and retry current student
            }
            
            // Determine grade and remark
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
            
            // Update grade count in the array
            gradeCount[grade]++;
            
            // Display individual result
            System.out.println("Student " + studentCount + " - Score: " + score + 
                             ", Grade: " + grade + ", Remark: " + remark);
            System.out.println("----------------------------------------");
            
            studentCount++; // Don't forget to increment the counter!
        }
        
        // Display summary report
        System.out.println("\n=== GRADE SUMMARY ===");
        System.out.println("Grade\tCount\tRemark");
        System.out.println("-----\t-----\t------");
        
        String[] remarks = {"", "Distinction", "Distinction", "Credit", "Credit", 
                           "Credit", "Credit", "Pass", "Pass", "Fail"};
        
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + "\t" + gradeCount[i] + "\t" + remarks[i]);
        }
        
        scanner.close();
    }
}