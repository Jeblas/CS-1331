/**
 * Represents the checkout page
 *
 * @author Isabella Plonk
 * @author jblasco6
 * @version 1.0
 */
public class CheckoutPage {
    private MyArrayList<Product> shoppingCart;
    private MyArrayList<Product> itemsInStock;

    /**
     * Default CheckoutPage constructor
     *
     */
    public CheckoutPage() {
        //Server server = new Server();
        shoppingCart = new MyArrayList<>();
        itemsInStock = (MyArrayList<Product>) Server.getProducts();
    }

    /**
     * @return Array list of products in stock
     */
    public MyArrayList<Product> getItemsInStock() {
        return itemsInStock;
    }

    /**
     * @return ArrayList of products in shopping cart
     */
    public MyArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @return subtotal of the cart
     */
    public double getSubtotal() {
        double total = 0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * @return cost of shipping
     */
    public double getShipping() {
        if (getSubtotal() <= 50 && getSubtotal() != 0) {
            return 8.95;
        }
        return 0;
    }

    /**
     * @return total cost of products with shipping
     */
    public double getTotal() {
        return getSubtotal() + getShipping();
    }

    /**
     * @param product item to be added to cart
     */
    public void addToCart(Product product) {
        try {
            Server.checkStock(product);
        } catch (ProductOutOfStockException e) {
            itemsInStock.removeAll(product);
            System.out.println(e.getMessage());
            //System.out.println("Out of stock.");
        }
        shoppingCart.add(product);
    }

    /**
     * @param card Credit card to use for payment
     */
    public void payForCart(CreditCard card) {
        if (shoppingCart.isEmpty()) {
            return;
        }

        try {
            Server.checkTraffic();
            card.pay(getTotal());
        } catch (SiteOverloadException e) {
            System.out.println(e.getMessage());
            //System.out.println("Site is overloaded");
            return;
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return;
        }

        shoppingCart.clear();
        System.out.println("Cart was successfully purchased");
    }

    /**
     * @param position position of item to remove from cart
     */
    public void removeFromCart(int position) {
        //itemsInStock.add(shoppingCart.remove(position));
        shoppingCart.remove(position);
        System.out.println("Item at position " + (position + 1)
                + " in cart has been removed.");
    }

    /**
     *
     * @return String of the checkout page
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                           KYLIE COSMETICS℠\n");
        s.append("----------------------------------------------------------"
            + "------------\n");
        int i = 1;
        for (Product product : shoppingCart) {
            s.append("(" + i + ") " + product + "\n");
            i++;
        }
        s.append(String.format("Total number of items: %d%n",
            shoppingCart.size()));
        s.append(String.format("Subtotal: $%.2f%n", getSubtotal()));
        s.append(String.format("Shipping: $%.2f%n", getShipping()));
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("Total: $%.2f%n", getTotal()));
        s.append("Enter 'pay' to checkout or 'back' to"
                + " return to the main menu.\n");
        s.append("Enter the number of an item to remove it"
                + " from the shopping cart.\n");
        return s.toString();
    }
}
