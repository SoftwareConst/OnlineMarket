public class Person implements Cloneable {	//Person details along with bank details and address
String fullName; 
boolean student; 
private Address address;
Bank bankpin ;


public Person(String fullName, boolean student, Bank bankpinC, Address address) {
	super();
	this.fullName = fullName;
	this.student = student;
	this.bankpin=bankpinC; 
        this.address= address;
}



public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}

public boolean isStudent() {
	return student;
}
public void setStudent(boolean student) {
	this.student = student;
}


public Bank getBankpin() {
	return bankpin;
}
public void setBankpin(Bank bankpinC) { //Bank pin cloning
	this.bankpin = bankpinC;
} 


public Object clone() {
	try {
		return super.clone();
	}catch(CloneNotSupportedException ex) {
		return null;
	}
}

public String toString() {
	return "Full Name: " + fullName + "\t is a Student: " + student + "\tBank Pin:" + this.bankpin.toString() + "\nAddress: "+ address.getFullAddress();
}


}
