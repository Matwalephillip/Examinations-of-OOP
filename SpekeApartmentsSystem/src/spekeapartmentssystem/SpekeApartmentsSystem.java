import java.util.Scanner;

public class SpekeApartmentsSystem {
    private static GymArea gym = new GymArea();
    private static SwimmingArea swimmingPool = new SwimmingArea();
    private static Object activeArea; // Can hold either GymArea or SwimmingArea
    private static String activeAreaType = "G"; // Default to Gym
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        activeArea = gym; // Set default active area
        
        System.out.println("=== Speke Apartments Accommodation Areas Control System ===");
        
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();
            
            switch (choice) {
                case "S":
                    selectActiveArea(scanner);
                    break;
                case "W":
                    addOccupants(scanner);
                    break;
                case "X":
                    removeOccupants(scanner);
                    break;
                case "Y":
                    switchOnLight(scanner);
                    break;
                case "Z":
                    switchOffLight(scanner);
                    break;
                case "R":
                    reportStatus();
                    break;
                case "Q":
                    System.out.println("Thank you for using Speke Apartments System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("S - Select active area (G = Gym, P = Swimming)");
        System.out.println("W - Add n occupants to active area");
        System.out.println("X - Remove n occupants from active area");
        System.out.println("Y - Switch ON a light (1-3)");
        System.out.println("Z - Switch OFF a light (1-3)");
        System.out.println("R - Report status");
        System.out.println("Q - Quit program");
        System.out.println("Active Area: " + (activeAreaType.equals("G") ? "Gym" : "Swimming Pool"));
        System.out.println("===============================");
    }
    
    private static void selectActiveArea(Scanner scanner) {
        System.out.print("Select area (G = Gym, P = Swimming Pool): ");
        String areaChoice = scanner.nextLine().toUpperCase();
        
        if (areaChoice.equals("G")) {
            activeArea = gym;
            activeAreaType = "G";
            System.out.println("Gym Area is now active.");
        } else if (areaChoice.equals("P")) {
            activeArea = swimmingPool;
            activeAreaType = "P";
            System.out.println("Swimming Pool Area is now active.");
        } else {
            System.out.println("Invalid area selection! Please enter G or P.");
        }
    }
    
    private static void addOccupants(Scanner scanner) {
        int n = getValidInteger(scanner, "Enter number of occupants to add: ");
        if (n > 0) {
            if (activeArea instanceof GymArea) {
                ((GymArea) activeArea).addOccupants(n);
            } else {
                ((SwimmingArea) activeArea).addOccupants(n);
            }
            System.out.println(n + " occupants added successfully.");
        }
    }
    
    private static void removeOccupants(Scanner scanner) {
        int n = getValidInteger(scanner, "Enter number of occupants to remove: ");
        if (n > 0) {
            if (activeArea instanceof GymArea) {
                ((GymArea) activeArea).removeOccupants(n);
            } else {
                ((SwimmingArea) activeArea).removeOccupants(n);
            }
            System.out.println(n + " occupants removed successfully.");
        }
    }
    
    private static void switchOnLight(Scanner scanner) {
        int lightNumber = getValidLightNumber(scanner, "Enter light number to switch ON (1-3): ");
        if (lightNumber != -1) {
            if (activeArea instanceof GymArea) {
                ((GymArea) activeArea).switchOnLight(lightNumber);
            } else {
                ((SwimmingArea) activeArea).switchOnLight(lightNumber);
            }
            System.out.println("Light " + lightNumber + " switched ON.");
        }
    }
    
    private static void switchOffLight(Scanner scanner) {
        int lightNumber = getValidLightNumber(scanner, "Enter light number to switch OFF (1-3): ");
        if (lightNumber != -1) {
            if (activeArea instanceof GymArea) {
                ((GymArea) activeArea).switchOffLight(lightNumber);
            } else {
                ((SwimmingArea) activeArea).switchOffLight(lightNumber);
            }
            System.out.println("Light " + lightNumber + " switched OFF.");
        }
    }
    
    private static void reportStatus() {
        if (activeArea instanceof GymArea) {
            ((GymArea) activeArea).reportStatus();
        } else {
            ((SwimmingArea) activeArea).reportStatus();
        }
    }
    
    // Validation methods
    private static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
    
    private static int getValidLightNumber(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int lightNumber = Integer.parseInt(scanner.nextLine());
                if (lightNumber >= 1 && lightNumber <= 3) {
                    return lightNumber;
                } else {
                    System.out.println("Light number must be 1, 2, or 3. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1-3.");
            }
        }
    }
}