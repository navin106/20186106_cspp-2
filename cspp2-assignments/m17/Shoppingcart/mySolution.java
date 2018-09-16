import java.util.Scanner;
/**
 * item_description.
 */
class Item {
	private String itemname;
	private int quantity;
	private Float price;
	Item(String name, int quant, Float cost) {
		itemname = name;
		quantity = quant;
		price = cost;
	}
	Item(String name, int quant) {
		itemname = name;
		quantity = quant;
	}
	public String getitemname() {
		return itemname;
	}

	public void setitemname(String itemname) {
		this.itemname = itemname;
	}
	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getprice() {
		return price;
	}

	public void setprice(Float price) {
		this.price = price;
	}
}
class ShoppingCart {
	Item[] cataloglist;
	int catalogsize = 0;
	Item[] cartlist;
	int cartsize = 0;
	void addToCatalog(Item item) {
		cataloglist[catalogsize++] = item;
	}
	void addToCart(Item item) {
		for (int i = 0; i < catalogsize; i++) {
			if (cataloglist[i].getitemname().equals(item.getitemname())) {
				for (int j = 0; j < cartsize; j++) {
					if (cartlist[i].getitemname().equals(item.getitemname())) {
						cartlist[i].setquantity(cartlist[i].getquantity() + item.getquantity());
						return;
					}

				}
				cartlist[cartsize++] = item;
				return;

			}

		}
	}
	void removeFromCart(Item item) {
		for (int i = 0; i < cartsize; i++) {
			if (cartlist[i].getitemname().equals(item.getitemname())) {
				if (cartlist[i].getquantity() == Item.getquantity()) {
					cartlist[i] = cartlist[i + 1];
					cartsize--;
					return;
				}
				cartlist[i].setquantity(cartlist[i].setquantity() - item.setquantity());
				return;
			}
		}
	}
	void showCart() {
		for (int i = 0; i < cartsize; i++) {
			System.out.println(cartlist[i].getitemname() + " " + cartlist[i].getquantity());

		}
	}
	void showCatalog() {
		for (int i = 0; i < catalogsize; i++) {
			System.out.println(cataloglist[i].getitemname() + " " + cataloglist[i].getquantity() + " " + cataloglist[i].getprice());
		}
	}
	Double getTotalAmount() {
		Double ta = 0.0;
		for (int i = 0; i < cartsize; i++) {
			for (int j = 0; j < catalogsize; j++) {
				if (cartlist[i].getitemname().equals(cataloglist[j].getitemname())) {
					ta += cartlist[j].getquantity() * cataloglist[j].getprice();
				}
			}
		}
		return ta;
	}
	Double getPayableAmount() {
		return (getTotalAmount() * (1 + 15 / 100));
	}

	void printlnvoice() {
		System.out.println("Name quantity Price");
		showCart();
		getTotalAmount();
		System.out.println("Disc%" + 0.0);
		System.out.println("Tax: " + 15.0);
		getPayableAmount();
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart sct = new ShoppingCart();
		int nooftestcase =  sc.nextInt();
		System.out.println();
		for (int i = 0; i < nooftestcase; i++) {
			String[] token = (sc.nextLine()).split(" ");
			String[] check = (token[1]).split(",");
			switch (token[0]) {
			case "Item":
				sct.addToCatalog(new Item(check[0], Integer.parseInt(check[1]), Float.parseFLoat(check[2])));
				break;
			case "catalog":
				sct.showCatalog();
				break;
			case "add":
				sct.addToCart(new Item(check[0], Integer.parseInt(check[1])));
				break;
			case "show":
				sct.showCart();
				break;
			case "totalAmount":
				sct.getTotalAmount();
				break;
			case "remove":
				sct.removeFromCart(new Item(check[0], Integer.parseInt(check[1])));
				break;
			case "payableAmount":
				sct.getPayableAmount();
				break;
			case "print":
				sct.printlnvoice();
				break;
			// case "coupon":
			// 	if (tokens.length > 1) {
			// 		String coupon = tokens[1];
			// 		shoppingCart.applyCoupon(coupon);
			// 		break;
			// 	}
			default:
				break;
			}


		}
	}
}