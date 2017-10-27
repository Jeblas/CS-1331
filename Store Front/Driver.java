import java.util.Scanner;

/**
 * Driver class for HW5
 *
 * @author Isabella Plonk
 * @version 1.0
 */
public class Driver {

    private static String name;
    private static CheckoutPage checkoutPage;
    private static CreditCard card;

    /**
     * Runner
     * @param args program arugments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        name = sc.nextLine();
        StringBuilder clear = new StringBuilder();
        for (int i = 0; i < 25; ++i) {
            clear.append("\n");
        }
        System.out.println(clear);
        checkoutPage = new CheckoutPage();
        card = new CreditCard(150);
        System.out.println(homePage());
        String choice = sc.nextLine();
        System.out.println(clear);
        do {
            ArrayListInterface<Product> stock = checkoutPage.getItemsInStock();
            ArrayListInterface<Product> shoppingCart
                = checkoutPage.getShoppingCart();
            if (choice.equals("1")) {
                System.out.println(shoppingPage());
                String input = sc.nextLine();
                while (!(input.equalsIgnoreCase("back"))) {
                    int i = Integer.parseInt(input);
                    if (i <= 0 || i > stock.size()) {
                        System.out.println("Please enter a valid number.");
                        System.out.println();
                        input = sc.nextLine();
                        continue;
                    }
                    Product added = stock.get(i - 1);
                    checkoutPage.addToCart(added);
                    System.out.println(clear);
                    System.out.println(shoppingPage());
                    input = sc.nextLine();
                }
            } else if (choice.equals("2")) {
                System.out.println(checkoutPage);
                String input = sc.nextLine();
                while (!(input.equalsIgnoreCase("back"))) {
                    if (input.equalsIgnoreCase("pay")) {
                        checkoutPage.payForCart(card);
                    } else {
                        int i = Integer.parseInt(input);
                        if (i <= 0 || i > shoppingCart.size()) {
                            System.out.println("Please enter a valid number.");
                            System.out.println();
                            input = sc.nextLine();
                            continue;
                        }
                        checkoutPage.removeFromCart(i - 1);
                    }
                    System.out.println(clear);
                    System.out.println(checkoutPage);
                    input = sc.nextLine();
                }
            } else if (choice.equals("3")) {
                System.out.println(
                        "Thank you for shopping at Kylie Cosmetics!");
                System.exit(0);
            } else {
                System.out.println(clear);
                System.out.println("That is not a valid option. Try again.");
                continue;
            }
            System.out.println(clear);
            System.out.println(homePage());
            choice = sc.nextLine();
            System.out.println(clear);
        } while (!choice.equalsIgnoreCase("quit"));
    }

    private static String homePage() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "-------------\n");
        s.append("                             KYLIE COSMETICS℠\n");
        s.append("----------------------------------------------------------"
            + "-------------\n");
        s.append("Welcome to Kylie Cosmetics℠, " + name + "!\n"
            + "After two long years of dreaming about this, "
            + "I am so excited to finally \n"
            + "share my cosmetic secrets with you."
            + " Kylie Cosmetics℠ is a collection\n"
            + "of products I created working with my amazing"
            + " team in our lab to design\n"
            + "the perfect ‘Kylie look.’ I can't wait to see"
            + " how beautiful everyone\n"
            + "is going to look! Use #KylieCosmetics to share"
            + " your photos with me.\n");
        s.append("----------------------------------------------------------"
            + "-------------\n");
        s.append("To explore KylieCosmetics℠, enter \n");
        s.append("(1) to go shopping\n");
        s.append("(2) to checkout\n");
        s.append("(3) to logout\n");
        return s.toString();
    }

    private static String shoppingPage() {
        ArrayListInterface<Product> products = checkoutPage.getItemsInStock();
        int count = 1;
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "-------------\n");
        s.append("                             KYLIE COSMETICS℠\n");
        s.append("----------------------------------------------------------"
            + "-------------\n");
        for (Product product : products) {
            s.append("(" + count + ")  " + product + "\n");
            ++count;
        }
        s.append("----------------------------------------------------------"
            + "-------------\n");
        s.append("Enter the number of the item to add it to your cart"
            + " or enter 'back' to \nreturn to the home page.");
        return s.toString();
    }
}