public class Change {

    public static String getChangeString (double owed, double payment) {
        double change = payment - owed;
        System.out.printf("Change: $%.2f\n", change);
        
        String result = "";

        if (change >= 50.00) {
            int fifties = findCoin (change, 50.00);
            change -= 50.00 * fifties;
            result += ("\nFifties: " + fifties);

        }
        if (change >= 20.00) {
            int twenties = findCoin (change, 20.00);
            change -= 20.00 * twenties;
            result += ("\nTwenties: " + twenties);

        }
        if (change >= 10.00) {
            int tens = findCoin (change, 10.00);
            change -= 10.00 * tens;
            result += ("\nTens: " + tens);

        }
        if (change >= 5.00) {
            int fives = findCoin (change, 5.00);
            change -= 5.00 * fives;
            result += ("\nFives: " + fives);

        }
        if (change >= 1.00) {
            int ones = findCoin (change, 1.00);
            change -= 1.00 * ones;
            result += ("\nOnes: " + ones);
            
        }
        if (change >= 0.25) {
            int quarters = findCoin (change, 0.25);
            change -= 0.25 * quarters;
            result += ("\nQuarters: " + quarters);
            
        }
        if (change >= 0.10) {
            int dimes = findCoin (change, 0.10);
            change -= 0.10 * dimes;
            result += ("\nDimes: " + dimes);

        }
        if (change >= 0.05) {
            int nickels = findCoin (change, 0.05);
            change -= 0.05 * nickels;
            result += ("\nNickels: " + nickels);

        }
        if (change > 0.00) {
            int pennies = findCoin (change, 0.01);
            change -= 0.01 * pennies;
            result += ("\nPennies: " + pennies);

        }
        return result;
    }
    
    public static int findCoin (double change, double value) {
        int finalCoin = 0;
        double coin = change;
        if (coin >= value) {
            while (coin >= value) {
                coin -= value;
                finalCoin ++;
            }
            return finalCoin;
        }
        else {
            return 0;
        }
    }
}
