
public class BabyMealScheduler {

    public static void main(String[] args) {
        // Constants for the problem
        final int CUP_CAPACITY_ML = 500; // Half a liter is 500ml
        final int PORRIDGE_FEED_INTERVAL_MIN = 45;
        final int MILK_FEED_INTERVAL_MIN = 30;
        final int PORRIDGE_TOTAL_ML = 2000; // 2 liters is 2000ml
        final int MILK_TOTAL_ML = 2000;     // 2 liters is 2000ml

        // Calculate the number of feeds for each meal type
        int porridgeFeeds = PORRIDGE_TOTAL_ML / (CUP_CAPACITY_ML / 2); // Half cup of porridge
        int milkFeeds = MILK_TOTAL_ML / CUP_CAPACITY_ML; // Full cup of milk

        System.out.println("Number of Porridge Feeds (half-cup each): " + porridgeFeeds);
        System.out.println("Number of Milk Feeds (full-cup each): " + milkFeeds);

        // Calculate total feeding time
        // The key insight: The baby alternates between meals, and the timer starts after each feed.
        // We need to simulate the feeding schedule until both porridge and milk are finished.

        int porridgeRemaining = porridgeFeeds;
        int milkRemaining = milkFeeds;
        int totalTime = 0;
        boolean lastFeedWasPorridge = false; // Track the last meal to know which timer to add

        System.out.println("\n--- Simulating Feeding Schedule ---");
        while (porridgeRemaining > 0 || milkRemaining > 0) {
            // Decision logic: Feed porridge if available and it's its "turn" or if milk is finished.
            // A simple fair alternation is to feed porridge first, then milk, then porridge, etc.
            if (porridgeRemaining > 0 && (!lastFeedWasPorridge || milkRemaining == 0)) {
                System.out.println("Feed: Half-cup of Porridge. Wait for " + PORRIDGE_FEED_INTERVAL_MIN + " mins.");
                totalTime += PORRIDGE_FEED_INTERVAL_MIN;
                porridgeRemaining--;
                lastFeedWasPorridge = true;
            } else if (milkRemaining > 0) {
                System.out.println("Feed: Full-cup of Milk. Wait for " + MILK_FEED_INTERVAL_MIN + " mins.");
                totalTime += MILK_FEED_INTERVAL_MIN;
                milkRemaining--;
                lastFeedWasPorridge = false;
            }
        }

        // Display the final result
        System.out.println("\n=== RESULT ===");
        System.out.println("The baby will finish all porridge and milk in: " + totalTime + " minutes.");
        
        // Optional: Convert to hours and minutes for better readability
        int hours = totalTime / 60;
        int minutes = totalTime % 60;
        System.out.println("Which is approximately: " + hours + " hours and " + minutes + " minutes.");
    }
}
