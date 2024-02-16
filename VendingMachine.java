import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        String[] snackNames = new String[]{"Potato Chips", "Pretzels", "Fritos", "Cheez-Its", "Snickers Bar", "Kit Kat Bar", "Oreo Cookies", "Rice Krispy Treat", "Trail Mix", "Popcorn", "Fruit Snacks", "Beef Jerky", "Suspicious Snack"};
        double[] snackPrices = new double[]{1.25, 1.00, 1.25, 1.50, 1.50, 1.25, 1.50, 1.25, 1.00, 1.25, 1.00, 1.50, 1.75};

        for (int i = 0; i < snackNames.length; i++) {
            String formattedPrice = String.format("%.2f", snackPrices[i]);
            System.out.println((i + 1) + ". " + snackNames[i] + " | $" + formattedPrice);
        }

        //Scanner scan = new Scanner(System.in);

        //tasks accomplished: variety of snacks available for purchase, each snack has a price
    }
}