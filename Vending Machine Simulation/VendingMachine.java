import java.util.Random;

/**
 * Class for VendingMachine
 * @author jblasco6
 */
public class VendingMachine {

    private static double totalSales = 0;
    private VendingItem[][][] grid = new VendingItem[6][3][5];
    private int freeChance;
    private Random rand;

    /**
     * Default Constructor
     *
     */
    public VendingMachine() {
        this.freeChance = 0;
        this.rand = new Random();
        this.restock();
    }

    /**
     *  Uses user input select and vend an item
     *  @param code user input to select item to vend
     *  @return emun of the item vended
     */
    public VendingItem vend(String code) {
        // Parse string input
        code = code.toUpperCase();
        int sRow = code.charAt(0) - 65;
        int sCol = code.charAt(1) - 49;

        // Check if input code is valid
        if ((sRow > 5 || sRow < 0) || (sCol > 2 || sCol < 0)) {
            System.out.println("Invalid input.");
            return null;
        }

        // find item in input location
        VendingItem itemToVend = grid[sRow][sCol][0];

        // Check if row/col is empty
        if (itemToVend == null) {
            System.out.print("Item is not in stock.");
            return null;
        }

        // Shift items in selected position
        for (int k = 0; k < 4; ++k) {
            grid[sRow][sCol][k] = grid[sRow][sCol][k + 1];
        }
        grid[sRow][sCol][4] = null;

        // Check if dispensed item is free
        if (!this.free()) {
            totalSales += itemToVend.getPrice();
            return itemToVend;
        }
        System.out.println("Congrats, this item is free!");
        return itemToVend;
    }

    /**
     * Checks if an item is free
     * @return boolean determinening if the item is free
     */
    private boolean free() {
        if (rand.nextInt(100) < freeChance) {
            freeChance = 0;
            return true;
        } else {
            ++freeChance;
            return false;
        }
    }

    /**
     * Restock the vending maching with random vending items
     */
    public void restock() {
        // TODO make the Vending Machine size variable
        int numEnums = VendingItem.values().length;
        VendingItem itemToStock;
        for (int rows = 0; rows < 6; ++rows) {
            for (int cols = 0; cols < 3; ++cols) {
                for (int stackPos = 0; stackPos < 5; ++stackPos) {
                    // rand vending item using rand rand depending
                    //  on the number of enums
                    itemToStock = VendingItem.values()[rand.nextInt(numEnums)];
                    this.grid[rows][cols][stackPos] = itemToStock;
                }
            }
        }
    }

    /**
     * returns the static totalSales variable value
     * @return total sales from all vending machines
     */
    public static double getTotalSales() {
        return totalSales;
    }

    /**
     * Calculate the number of items in a vending machine
     * @return number of items in a vending machine
     */
    public int getNumberOfItems() {
        int numberOfItems = 0;
        for (int rows = 0; rows < 6; ++rows) {
            for (int cols = 0; cols < 3; ++cols) {
                for (int stackPos = 0; stackPos < 5; ++stackPos) {
                    if (grid[rows][cols][stackPos] == null) {
                        break;
                    }
                    ++numberOfItems;
                }
            }
        }
        return numberOfItems;
    }

    /**
     * Calculate the total value of items in a vending machine
     * @return the total value of items in a vending machine
     */
    public double getTotalValue() {
        double totalValue = 0;

        for (int rows = 0; rows < 6; ++rows) {
            for (int cols = 0; cols < 3; ++cols) {
                for (int stackPos = 0; stackPos < 5; ++stackPos) {
                    if (grid[rows][cols][stackPos] == null) {
                        break;
                    }
                    totalValue  += grid[rows][cols][stackPos].getPrice();
                }
            }
        }
        return totalValue;
    }

    /**
     *  Outs the current state of a vending machine
     *  @return String representation of a vending machine
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < grid.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < grid[0].length; j++) {
                VendingItem item = grid[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));
        return s.toString();
    }
}
