import java.util.Scanner;

public class ConcaveMirror {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== CONCAVE MIRROR FOCAL LENGTH VERIFICATION ===");
        
        // PART B: Accept object distance u (always negative for concave mirrors)
        System.out.print("Enter object distance u (in cm): ");
        double u = input.nextDouble();
        u = -Math.abs(u); // Ensure u is negative for concave mirror
        
        // PART B: Accept image distance v
        System.out.print("Enter image distance v (in cm): ");
        double v = input.nextDouble();
        
        // PART B: Calculate focal length using mirror formula
        double f = 1 / ((1/v) + (1/u));
        
        // PART B & C: Display results
        System.out.printf("\nFocal Length Calculation Results:%n");
        System.out.printf("Object distance (u): %.2f cm%n", u);
        System.out.printf("Image distance (v): %.2f cm%n", v);
        System.out.printf("Focal length (f): %.2f cm%n", Math.abs(f));
        
        // PART C: Check if mirror is acceptable (f between 21.0cm and 25.0cm inclusive)
        System.out.println("\n=== MIRROR ACCEPTABILITY CHECK ===");
        if (f >= 21.0 && f <= 25.0) {
            System.out.println("✅ ACCEPTABLE - Focal length is within WAKISHA MOCK range (21.0cm - 25.0cm)");
        } else {
            System.out.println("❌ NOT ACCEPTABLE - Focal length is outside required range");
            System.out.println("   Required: 21.0cm ≤ f ≤ 25.0cm");
            System.out.printf("   Actual: %.2f cm%n", f);
        }
        
        input.close();
    }
}
