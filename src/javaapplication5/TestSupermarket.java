import java.util.Scanner;
import java.util.ArrayList;

public class TestSupermarket {

	public static void main(String[] args){
		double sum = 0;
		Scanner input = new Scanner(System.in);
		Boolean GoBack = true;
		Boolean bGoBack = true;
		Boolean transaction= false;
		int decision = 0;
		ArrayList <Object> Cart = new ArrayList <Object>(); // Array list for all items added to cart
		ArrayList <Double> SubTotal = new ArrayList <Double>(); //Array list of Total Prices of all items in cart
		ArrayList <GroceryDepartment> GroceryDep = new ArrayList <GroceryDepartment>(); //Array List for items in grocery department
		ArrayList <KitchenwareDepartment> KitchenwareDep = new ArrayList <KitchenwareDepartment>(); //Array List for items in kitchenware department
		ArrayList <CleaningDepartment> CleaningDep = new ArrayList <CleaningDepartment>(); //Array List for items in Cleaning department
//Person Class		
 
//Grocery Items
GroceryDep.add( new GroceryDepartment("Steak",0.5,1));		
GroceryDep.add( new GroceryDepartment("Onion",0.15,1));
GroceryDep.add( new GroceryDepartment("Garlic",0.20,1));
		
//Kitchenware Items
KitchenwareDep.add(new KitchenwareDepartment("Plate",10,1));
KitchenwareDep.add(new KitchenwareDepartment("Fork",5,1));
KitchenwareDep.add(new KitchenwareDepartment("Knife",5,1));
KitchenwareDep.add(new KitchenwareDepartment("Spoon",5,1));

//Cleaning Department
CleaningDep.add(new CleaningDepartment("Dish Soap", 15,1));
CleaningDep.add(new CleaningDepartment("Dish Sponge", 2.5,1));
CleaningDep.add(new CleaningDepartment("Paper Towels", 5,1));
CleaningDep.add(new CleaningDepartment("Garbage Bag", 1.5,1));

//Bank Account creation and deposit
System.out.println("_-==============================-_");
System.out.println("\tWelcome to the bank!");
System.out.println("==================================");
System.out.println("To open an account with us please enter your full name:");
String fullName = input.nextLine();
System.out.println("Enter your city:");
String city = input.nextLine();
System.out.println("Enter your State:");
String state = input.nextLine();
System.out.println("Enter your ZIP code:");
String zip = input.nextLine();
System.out.println("Are you a student? true or false");

Boolean student = input.nextBoolean();
Address ad = new Address(city, state, zip);
Person customer = new Person(fullName, student,new Bank((int) (Math.random()*9000)+1000), ad); //Initial creation of customer object along with randomly generated four digit pin and address


System.out.println("Your account has been created.\n");
Person customerClone =(Person)customer.clone();  //Cloning of customer for updated details. 
System.out.println("Original Account Details:\n"+customer);
System.out.println("\nWould you like to change your pin number at this time? y or n");// Asks user if he wants to change the pre-assignd pin number

char bAnswer = input.next().charAt(0);
if(bAnswer == 'y' ) {
	while(bGoBack) {
	System.out.println("Please enter your existing four digit pin:");
	int reference = input.nextInt();
	
	if (reference == customerClone.bankpin.getPin()) {
		System.out.println("Please enter your new four digit pin: ");
customerClone.getBankpin().setPin(input.nextInt());
//customerClone.bankpin.setPin(input.nextInt());
System.out.println("Your new four digit pin is "+customerClone.bankpin.getPin()+" please don't forget it.");
		break;
		
	} else {
		System.out.println("You have entered an incorrect PIN, please try again");
	}
	}
	
}
System.out.println("What is the amount you would like to deposit in your account?"); //User Deposit
customerClone.bankpin.setDeposit(input.nextDouble());															//CHANGED*****
System.out.println("\n\n\n\n==================================");
//System.out.println("Original Account Details:\t"+customer);	//Customer account at creation
System.out.println("Account Details:\t"+customerClone);//Cloned Customer account 
System.out.println("==================================\n\n");




//Supermarket
System.out.println("_-==============================-_");
System.out.println("\tWelcome to the Supermarket!");
System.out.println("==================================");
//Loop to go between departments and adding items to cart
while(GoBack) {
	System.out.println("Which Department would you like to visit?\nEnter department number or any other number to go to the checkpoint.\nGrocery: \t1\nKitchenware:\t2\nCleaning:\t3\nEnter Any other number to proceed to the Checkpoint.");
	decision = input.nextInt();
	System.out.println("======================================");
if (decision == 1) {
	System.out.println("Welcome to the Grocery Department");
	System.out.println("======================================");
	System.out.println("Items Listed: ");
	System.out.println(GroceryDep+"\n");

	System.out.println("===============================");
	for (int i = 0; i<GroceryDep.size() ; i++) {
		System.out.println("Would you like add "+GroceryDep.get(i).getItemName() +" to your cart? Enter y if yes");
	char	answer = input.next().charAt(0);
		if(answer == 'y' ) {
			System.out.println("How many grams of "+GroceryDep.get(i).getItemName()+" would you like? \t Price per gram:\tRM"+GroceryDep.get(i).getPrice());
			GroceryDep.get(i).setGrams(input.nextDouble()); // User enters amount in grams of specified item
			System.out.println("Add "+GroceryDep.get(i).getGrams()+" grams of "+GroceryDep.get(i).getItemName()+" and Total Price:RM"+GroceryDep.get(i).getTotalPrice()+" to cart? enter y if yes ");
			answer = input.next().charAt(0);
			if (answer == 'y') {
				Cart.add(GroceryDep.get(i));//Adding item to cart for reciept display
				SubTotal.add(GroceryDep.get(i).getTotalPrice());//Adding total price of each item after xGrams or xQuantity(for kitchenware and cleaning dep)
			}
			
			

		}
	}

}
else if(decision ==2) {
	System.out.println("Welcome to the Kitchenware Department");
	System.out.println("======================================");
	System.out.println("Items Listed: ");
	System.out.println(KitchenwareDep+"\n");
	System.out.println("===============================");
	for (int i = 0; i<KitchenwareDep.size() ; i++) {
		System.out.println("Would you like add "+KitchenwareDep.get(i).getItemName() +" to your cart? Enter y if yes");
	char	answer = input.next().charAt(0);
		if(answer == 'y' ) {
		 System.out.println("How many "+KitchenwareDep.get(i).getItemName()+" would you like?\tIndividual Price: $"+KitchenwareDep.get(i).getTotalPrice());
			KitchenwareDep.get(i).setQuantity(input.nextInt());
			System.out.println("Add "+KitchenwareDep.get(i).getQuantity()+" "+KitchenwareDep.get(i).getItemName()+" and Total Price:RM"+KitchenwareDep.get(i).getTotalPrice()+" to cart? enter y if yes ");
			answer = input.next().charAt(0);
			if (answer == 'y') {
				Cart.add(KitchenwareDep.get(i));
				SubTotal.add(KitchenwareDep.get(i).getTotalPrice());
			}
	
		}
	}	
}
else if(decision == 3) {
	System.out.println("Welcome to the Cleaning Department");
	System.out.println("======================================");
	System.out.println("Items Listed: ");
	System.out.println(CleaningDep+"\n");
	System.out.println("===============================");
	for (int i = 0; i<CleaningDep.size() ; i++) {
		System.out.println("Would you like add "+CleaningDep.get(i).getItemName() +" to your cart? Enter y if yes");
	char	answer = input.next().charAt(0);
		if(answer == 'y' ) {
		 System.out.println("How many "+CleaningDep.get(i).getItemName()+" would you like?\tIndividual Price: RM"+CleaningDep.get(i).getTotalPrice());
			CleaningDep.get(i).setQuantity(input.nextInt());
			System.out.println("Add "+CleaningDep.get(i).getQuantity()+" "+CleaningDep.get(i).getItemName()+" and Total Price:RM"+CleaningDep.get(i).getTotalPrice()+" to cart? enter y if yes ");
			answer = input.next().charAt(0);
			if (answer == 'y') {
				Cart.add(CleaningDep.get(i));
				SubTotal.add(CleaningDep.get(i).getTotalPrice());
			}
	
		}
}
}

else {
break;

		}
}

//Checkpoint
System.out.println("_-==============================-_");
System.out.println("\tWelcome to the Checkpoint!");
System.out.println("==================================");
System.out.println("Items in your cart:\n"+Cart); // Displays all items in cart to user
System.out.println("==================================");
for (int i=0; i <SubTotal.size();i++) {
	sum+= SubTotal.get(i);				//Calculation of all items itemprices in arraylist
}
System.out.println("Total price of items in cart:\tRM"+sum); //Display total price
System.out.println("==================================");
for(int i = 0; i<3; i++){
System.out.println("Please enter your 4 digit pin"); //User input of 4 digit bank pin correctly
int referenceC= input.nextInt();
if (referenceC == customerClone.bankpin.getPin() ) {
	
			if (customerClone.isStudent()) { //If the customer is a student a 10% discount is applied
				System.out.println("Because you are a student you get a 10% Discount on your purchase.\nOrginal Price: $"+sum+"\nDiscounted amount: $"+sum*0.1+"\nPrice After Discount: $"+sum*0.9);
			
				if (customerClone.bankpin.getBalance()-(sum*0.9)<0) {	// If balance is less than total cost of items condition				//CHANGED*****
					System.out.println("Rejected : You don’t have enough funds.");
					break;
				}else {
				customerClone.bankpin.setWithdraw(sum*0.9); //Withdraw transaction of 10% discount total price									//CHANGED*****
				transaction= true;
				break;}
			//	System.out.println("Account Balance after charge: $"+customerClone.getBalance()); 		//Check Balance
			}
		
			else {
				if (customerClone.bankpin.getBalance()-(sum)<0) {// If balance is less than total cost of items condition			//CHANGED*****
					System.out.println("Rejected : You don’t have enough funds.");
					break;
				}else {
				customerClone.bankpin.setWithdraw(sum);//Withdraw transaction of total price
				transaction= true;
				break; 
				}
			}
	
	}




}

//Bill
System.out.println("\n\n===============================");
System.out.println("\t BILL:");
System.out.println("===============================\n\n\n\n\n");

if (transaction) {// If statement if transaction was processed
	System.out.println("Items Purchased: ");
	System.out.println(Cart);
	if(customerClone.isStudent()) { //Bill if customer is a student with account balance display after transaction
		System.out.println("Because you are a student you get a 10% Discount on your purchase.\nOrginal Price: RM"+sum+"\nDiscounted amount: RM"+sum*0.1+"\nPrice After Discount: RM"+sum*0.9);
		System.out.println("Amount to be deducted: RM"+customerClone.bankpin.getWithdraw());							//CHANGED*****
		System.out.println("===============================");
		System.out.println("Current account balance: RM"+customerClone.bankpin.getBalance());						//CHANGED*****
	
	}
	else {//Bill if customer with account balance display after transaction
		System.out.println("Amount to be deducted: RM"+customerClone.bankpin.getWithdraw());							//CHANGED*****
		System.out.println("===============================");

		System.out.println("Current account balance: RM"+customerClone.bankpin.getBalance());						//CHANGED*****
	}
}
else {// if transaction couldn't be processed due to invalid pin 3 times or not enough funds in account
	System.out.println("Transaction couldn't be processed");
}

//End
	}


	
}
