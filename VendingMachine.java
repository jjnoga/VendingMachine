import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("To use this vending machine, simply select an option, and then enter your money.");

        String[] snackNames = new String[]{"Potato Chips", "Pretzels", "Fritos", "Cheez-Its", "Snickers Bar", "Kit Kat Bar", "Oreo Cookies", "Rice Krispy Treat", "Trail Mix", "Popcorn", "Fruit Snacks", "Beef Jerky", "Suspicious Snack"};
        double[] snackPrices = new double[]{1.25, 1.00, 1.25, 1.50, 1.50, 1.25, 1.50, 1.25, 1.00, 1.25, 1.00, 1.50, 1.75};

        System.out.println("The following snacks are currently available:");

        for (int i = 0; i < snackNames.length; i++) {
            String formattedPrice = String.format("%.2f", snackPrices[i]);
            System.out.println((i + 1) + ". " + snackNames[i] + " | $" + formattedPrice);
        }

        System.out.println("Please select the number of the snack you would like");

        int selection = -1;
        do {
            try {
                int userInput = scanner.nextInt();
                if (userInput > 0 && userInput <= snackNames.length) {
                    selection = userInput - 1;

                    double currentAmount = 0;
                    double itemPrice = snackPrices[selection];

                    do {
                        try {
                            System.out.println("Current amount inserted: $" + String.format("%.2f", currentAmount));
                            System.out.print("Insert $1 bill (Enter 0 to finish): $");
                            double moneyInserted = scanner.nextDouble();

                            if (moneyInserted == 0) {
                                double change = currentAmount - itemPrice;
                    
                                if (change < 0) {
                                    System.out.println("Error: Insufficient funds. Please insert more $1 bills.");
                                } else if (change > 0) {
                                    System.out.println("Exact change: $" + String.format("%.2f", change));
                                    break;
                                }
                            } else if (moneyInserted == 1) {
                                currentAmount += moneyInserted;
                            } else {
                                System.out.println("Error: Only $1 bills are accepted. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Invalid input. Please enter a valid number.");
                            scanner.nextLine();
                        }
                    } while (true);

                    
                }
                else {
                    System.out.println("Error: That number does not correspond with a snack item, please try again.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error: That is not a valid number, please try again.");
                scanner.nextLine();
            }
        } while (selection < 0);
        
    }
}