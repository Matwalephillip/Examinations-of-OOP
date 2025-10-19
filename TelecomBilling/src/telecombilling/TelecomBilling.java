// This is the code for Part (c)
public class TelecomBilling {

    public static void main(String[] args) {
        // Constants for the billing system
        final double LOADING_FEE_PERCENTAGE = 0.10; // 10%
        final int CALL_COST_PER_SECOND = 200; // UGX per second

        // User's actions
        double airtimeLoaded = 10000.0; // UGX
        int callDurationSeconds = 5 * 60; // 5 minutes converted to seconds

        System.out.println("=== TELECOM BILLING STATEMENT ===");
        System.out.println("Airtime Loaded: UGX " + airtimeLoaded);

        // Step 1: Deduct the 10% loading charge
        double loadingFee = airtimeLoaded * LOADING_FEE_PERCENTAGE;
        double balanceAfterLoadingCharge = airtimeLoaded - loadingFee;

        System.out.println("\n--- Loading Charge ---");
        System.out.println("Loading Fee (10%): UGX " + loadingFee);
        System.out.println("Balance after loading charge: UGX " + balanceAfterLoadingCharge);

        // Step 2: Calculate and deduct the call cost
        double callCost = callDurationSeconds * CALL_COST_PER_SECOND;

        System.out.println("\n--- Call Charges ---");
        System.out.println("Call Duration: " + callDurationSeconds + " seconds");
        System.out.println("Call Cost: " + callDurationSeconds + " sec * UGX " + CALL_COST_PER_SECOND + " = UGX " + callCost);

        double finalBalance = balanceAfterLoadingCharge - callCost;

        // Display the final result
        System.out.println("\n=== FINAL BALANCE ===");
        System.out.println("Final Account Balance: UGX " + finalBalance);
    }
}
