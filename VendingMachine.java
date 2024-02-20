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

                    System.out.println("Please confirm that you would like to make this transaction (y/n)");
                    scanner.nextLine();
                    String input = scanner.nextLine();
                    while (!input.equals("y") && !input.equals("n")) {
                        System.out.println("Unrecognized input -- please try again. Enter y to confirm, n to cancel");
                        input = scanner.nextLine();
                    }
                    if (input.equals("y")) {
                        System.out.println("Here is your snack!");
                        System.out.println("WHIRRRRRRRRRR");
                        double change = currentAmount - itemPrice;
                        if (change > 0) {
                            System.out.println("And here is your change of " + String.format("$%.2f", change));
                            System.out.println("CLUNK CLUNK CLUNK");
                        }
                        System.out.println("GREAT snack choice by the way, you have great taste! Goodbye!");
                        System.exit(0);
                    }
                    else {
                        System.out.println("Canceling Transaction...");
                        System.out.println("Returning your money. Have a great day!");
                        System.exit(0);
                    }
                    
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