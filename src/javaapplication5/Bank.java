public class Bank {
int pin;
double deposit;
double withdraw; 
double balance;

// Bank pin class for pin cloning
public double getDeposit() {
	return deposit;
}


public Bank(int pin) {
this.pin=pin;
}

public void setDeposit(double deposit) {
	this.deposit = deposit;
	balance = balance + deposit		;// Adding funds to account
}

public double getWithdraw() {
	return withdraw;
}

public void setWithdraw(double withdraw) {
	this.withdraw = withdraw;
	balance = balance - withdraw;// Deducting funds from account
	
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}



public void setPin(int pin) {
	this.pin = pin;
}

public int getPin() {
	// TODO Auto-generated method stub
	return pin;
}

@Override
public String toString() {
	return "Bank Pin: " + pin+"\tCurrent Balance: $"+balance;
} 

}

