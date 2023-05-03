public class CleaningDepartment extends Department {

	
	double totalPrice;
	public CleaningDepartment() {}
	
	public CleaningDepartment(String itemName, double price, int quantity) {
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
		return quantity;		//Quantity of items added
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
		return getPrice() *getQuantity();	//Total Price of object after multiplying by quantity
	}

	@Override
	public String toString() {
		return "Item Name: \t"+itemName+"\tPrice:\tRM"+price+"\tQuantity:\t"+quantity+"\tTotalPrice: \tRM"+getTotalPrice()+"\n";
	}

	
	
	
	
}

