package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PromotionDataBase {

    private static final String PROMO_USAGE_FILE = "promo_usage.txt";

    /**
     * Checks if a user has already used a promotion.
     * It reads the promo_usage.txt file line by line.
     */
    public static boolean hasUserUsedPromo(String userEmail, String promoCode) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROMO_USAGE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // If a line matches BOTH the email and the promo code, they've used it.
                if (parts.length == 2 && parts[0].equalsIgnoreCase(userEmail) && parts[1].equalsIgnoreCase(promoCode)) {
                    return true; // Found a match, so it's used.
                }
            }
        } catch (IOException e) {
            // This happens if promo_usage.txt doesn't exist yet.
            // This is perfectly fine, it just means no one has used any promos.
        }
        // If we search the whole file and find no match, it's not used.
        return false;
    }

    /**
     * Records that a user has successfully used a promotion.
     * It appends a new line to the promo_usage.txt file.
     */
    public static void recordPromoUsage(String userEmail, String promoCode) {
        // The 'true' here means "append to the file", not "overwrite it".
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROMO_USAGE_FILE, true))) {
            writer.write(userEmail + "," + promoCode);
            writer.newLine(); // Adds a new line for the next entry.
        } catch (IOException e) {
            System.err.println("Error recording promotion usage for " + userEmail);
            e.printStackTrace();
        }
    }
}