import java.util.Scanner;

public class EliteSacco {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== ELITE SACCO INVESTMENT CALCULATOR ===");
        
        // Using FOR Loop
        System.out.println("\n--- Using FOR Loop ---");
        System.out.print("Enter number of members: ");
        int numMembers = input.nextInt();
        
        for (int i = 1; i <= numMembers; i++) {
            System.out.print("Enter principal amount for member " + i + ": UGX ");
            double principal = input.nextDouble();
            System.out.print("Enter time period (years): ");
            int time = input.nextInt();
            
            double interestRate = 0.05; // 5%
            double futureValue = principal * Math.pow(1 + interestRate, time);
            
            System.out.printf("Member %d: Investment value after %d years: UGX %.2f%n", 
                            i, time, futureValue);
            System.out.println("----------------------------------------");
        }
        
        // Using WHILE Loop
        System.out.println("\n--- Using WHILE Loop ---");
        System.out.print("Enter number of members: ");
        int numMembersWhile = input.nextInt();
        
        int count = 1;
        while (count <= numMembersWhile) {
            System.out.print("Enter principal amount for member " + count + ": UGX ");
            double principal = input.nextDouble();
            System.out.print("Enter time period (years): ");
            int time = input.nextInt();
            
            double interestRate = 0.05; // 5%
            double futureValue = principal * Math.pow(1 + interestRate, time);
            
            System.out.printf("Member %d: Investment value after %d years: UGX %.2f%n", 
                            count, time, futureValue);
            System.out.println("----------------------------------------");
            count++;
        }
        
        input.close();
    }
}