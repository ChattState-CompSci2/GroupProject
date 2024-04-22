public class Change {


    /**
     * Returns a string that lists the coin and bill change ammounts
     * @param owed The payment ammount
     * @param payment The ammount of tender given to the cashier
     */
    public static String getChangeString (double owed, double payment) {
        double change = payment - owed;
        
        String result = String.format("Change: $%.2f", change);

        if (change >= 50.00) {
            int fifties = findCoin (change, 50.00);
            change -= 50.00 * fifties;
            result += ("\n   Fifties: " + fifties);

        }
        if (change >= 20.00) {
            int twenties = findCoin (change, 20.00);
            change -= 20.00 * twenties;
            result += ("\n   Twenties: " + twenties);

        }
        if (change >= 10.00) {
            int tens = findCoin (change, 10.00);
            change -= 10.00 * tens;
            result += ("\n   Tens: " + tens);

        }
        if (change >= 5.00) {
            int fives = findCoin (change, 5.00);
            change -= 5.00 * fives;
            result += ("\n   Fives: " + fives);

        }
        if (change >= 1.00) {
            int ones = findCoin (change, 1.00);
            change -= 1.00 * ones;
            result += ("\n   Ones: " + ones);
            
        }
        if (change >= 0.25) {
            int quarters = findCoin (change, 0.25);
            change -= 0.25 * quarters;
            result += ("\n   Quarters: " + quarters);
            
        }
        if (change >= 0.10) {
            int dimes = findCoin (change, 0.10);
            change -= 0.10 * dimes;
            result += ("\n   Dimes: " + dimes);

        }
        if (change >= 0.05) {
            int nickels = findCoin (change, 0.05);
            change -= 0.05 * nickels;
            result += ("\n   Nickels: " + nickels);

        }
        if (change > 0.00) {
            int pennies = findCoin (change, 0.01);
            change -= 0.01 * pennies;
            result += ("\n   Pennies: " + pennies);

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
