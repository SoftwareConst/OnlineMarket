public class Address {	
	private String city;
	private String state;	
	private String zip;

	public Address( String city, String state, String zip)
        {	this.city = city;
		this.state = state;
		this.zip = zip;	;
        }

	public String getFullAddress() {	
		return  city+ ", " +state+ ", " +zip ; 
	}
        

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
}
