public class KitchenwareDepartment extends Department {

	
	public KitchenwareDepartment() {}
	
	public KitchenwareDepartment(String itemName, double price, int quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return getPrice() +getQuantity();//Total Price of object after multiplying by quantity
	}

	@Override
	public String toString() {
		return "Item Name: \t"+itemName+"\tPrice:\tRM"+price+"\tQuantity:\t"+quantity+"\tTotalPrice: \tRM"+getTotalPrice()+"\n";
	}

	
	
	
	
}	