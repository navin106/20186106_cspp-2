import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for item.
 */
class Item {
    /**
     * { item name }.
     */
    private String name;
    /**
     * { item quantity }.
     */
    private int quantity;
    /**
     * { item price }.
    */
    private float price;
    /**
     * { item catalog }.
     */
    private boolean inCatlog = false;
    /**
     * Constructs the object.
     *
     * @param      name1      The name
     * @param      quantity1  The quantity
     * @param      price1     The price
     */
    Item(final String name1, final int quantity1, final float price1) {
        this.name = name1;
        this.quantity = quantity1;
        this.price = price1;
        this.inCatlog = true;
    }
    /**
     * Constructs the object.
     *
     * @param      name1      The name
     * @param      quantity1  The quantity//
     */
    Item(final String name1, final int quantity1) {
        this.name = name1;
        this.quantity = quantity1;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name.
     *
     * @param      name1  The name
     */
    public void setName(final String name1) {
        this.name = name1;
    }
    /**
     * Gets the quantity.
     *
     * @return     The quantity.
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets the quantity.
     *
     * @param      quantity1  The quantity
     */
    public void setQuantity(final int quantity1) {
        this.quantity = quantity1;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return price;
    }
    /**
     * Sets the price.
     *
     * @param      price1  The price
     */
    public void setPrice(final float price1) {
        this.price = price1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (inCatlog) {
            return name + " " + quantity + " " + price;
        }
        return name + " " + quantity;
    }
}
/**
 * Class for shopping cartesian.
 */
class ShoppingCart {
    /**
     * { var_description }.
     */
    private static final double NUM = 10.0;
    /**
     * { var_description }.
     */
    private static final int NUM1 = 10;
    /**
     * { var_description }.
     */
    private static final float NUM2 = 0.15f;

    /**
     * { var_description }.
     */
    private static final float NUM3 = 0.01f;
    /**
     * { var_description }.
     */
    private ArrayList<Item> catlog;
    /**
     * { var_description }.
     */
    private ArrayList<Item> cart;
    /**
     * { var_description }.
     */
    private String[] arr = {
        "IND10", "IND20", "IND30", "IND50"};
    /**
     * { var_description }.
     */
    private ArrayList<String>
    couponCodes = new ArrayList<>(Arrays.asList(arr));
    /**
     * { var_description }.
     */
    private float coupon = 0.0f;
    /**
     * { var_description }.
     */
    private static final float NUM5 = 1.15f;
    /**
     * { var_description }.
     */
    private static final double NUM6 = 0.01;
    /**
     * { var_description }.
     */
    private boolean cflag = false;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        cart = new ArrayList<>();
        catlog = new ArrayList<>();
    }
    /**
     * Adds to catlog.
     *
     * @param      item  The item
     */
    public void addToCatlog(final Item item) {
        catlog.add(item);
    }
    /**
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        for (Item e : catlog) {
        if (e.getName().equals(item.getName())) {
            for (Item f : cart) {
                if (f.getName().equals(item.getName())) {
        f.setQuantity(f.getQuantity() + item.getQuantity());
                    return;
                    }
                }
                cart.add(item);
                return;
            }
        }
    }
    /**
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        for (Item f : cart) {
            if (f.getName().equals(item.getName())) {
                if (
            f.getQuantity() == item.getQuantity()) {
                    cart.remove(f);
                    return;
                }
        f.setQuantity(f.getQuantity() - item.getQuantity());
                return;
            }
        }
    }
    /**
     * Shows the cartesian.
     */
    public void showCart() {
        for (Item e : cart) {
            System.out.println(e);
        }
    }
    /**
     * Shows the catlog.
     */
    public void showCatlog() {
        for (Item e : catlog) {
            System.out.println(e);
        }
    }
    /**
     * Gets the price.
     *
     * @param      name  The name
     *
     * @return     The price.
     */
    public float getPrice(final String name) {
        for (Item e : catlog) {
            if (e.getName().equals(name)) {
                return e.getPrice();
            }
        }
        return 0.0f;
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public float getTotalAmount() {
        float amt = 0.0f;
        for (Item e : cart) {
            amt += e.getQuantity() * getPrice(e.getName());
        }
        return amt;
    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public float getPayableAmount() {
        /**
         * { var_description }.
         */
        float dscnt = NUM3 * coupon;
        /**
         * { item_description }.
         */
        return (getTotalAmount() * (1f - dscnt)) * NUM5;
    }
    /**
     * { function_description }.
     *
     * @param      couponCode  The coupon code
     */
    public void applyCoupon(final String couponCode) {
        if (couponCodes.contains(couponCode)) {
            if (!cflag) {
                coupon = Integer.parseInt(
                    couponCode.substring(2 + 1));
                cflag = true;
            }
            return;
        }
        System.out.println("Invalid coupon");
    }
    /**
     * { function_description }.
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (Item item : cart) {
            System.out.println(
                item.getName() + " " + item.getQuantity(
                    ) + " " + getPrice(item.getName()));
        }
        float total = getTotalAmount();
        System.out.println("Total:" + total);
        System.out.println("Disc%:" + NUM6 * coupon * total);
        System.out.println(
        "Tax:" + ((int) ((total * (
        1f - (NUM3 * coupon)) * NUM2) * NUM1)) / NUM);
        System.out.println(
            "Payable amount: " + ((int) (
                getPayableAmount() * NUM1)) / NUM);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * { var_description }.
     */
    private static final double NUM = 10.0;
    /**
     * { var_description }.
     */
    private static final int NUM1 = 10;
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            String[] tokens = sc.nextLine().split(" ");
            // System.out.println(Arrays.toString(tokens));
            switch (tokens[0]) {
            case "Item" :
                if (tokens.length > 1) {
                    String[] details = tokens[1].split(",");
                    shoppingCart.addToCatlog(
                new Item(details[0], Integer.parseInt(
                details[1]), Integer.parseInt(details[2])));
                    break;
                }
                break;
            case "catalog":
                shoppingCart.showCatlog();
                break;
            case "add":
                if (tokens.length > 1) {
                    String[] details = tokens[1].split(",");
                    shoppingCart.addToCart(
                new Item(
                details[0], Integer.parseInt(details[1])));
                    break;
                }
                break;
            case "show":
                shoppingCart.showCart();
                break;
            case "totalAmount":
                System.out.println(
                "totalAmount: "
                + shoppingCart.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: " + ((int) (
                shoppingCart.getPayableAmount() * NUM1)) / NUM);
                break;
            case "remove":
                if (tokens.length > 1) {
                    String[] details = tokens[1].split(",");
                    shoppingCart.removeFromCart(
                    new Item(
                details[0], Integer.parseInt(details[1])));
                    break;
                }
                break;
            case "coupon":
                // System.out.println("called");
                if (tokens.length > 1) {
                    String coupon = tokens[1];
                    shoppingCart.applyCoupon(coupon);
                    break;
                }
            case "print":
                // System.out.println("called");
                shoppingCart.printInvoice();
                break;
            default:
            break;
            }
        }
    }
}
