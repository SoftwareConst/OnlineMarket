public class GroceryDepartment extends Department {

	double grams;
	public GroceryDepartment() {}
	public GroceryDepartment(String itemName, double price,  double grams) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.grams = grams;
	}
	public double getPrice() {
		return price*getGrams();//Price of object after multiplying by grams
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	public double getGrams() {
		return grams;
	}
	public void setGrams(double grams) {
		this.grams = grams;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalPrice() {
		return getPrice();
	}

	@Override
	public String toString() {
		return "Item Name: \t"+itemName+"\t Weight: \t"+grams+" grams\tPrice per gram:\tRM"+price+" \tTotalPrice: \tRM"+getTotalPrice()+"\n";
	}

}

