package examQuestions;

public class ContactInfo {
	
	String homeAddress;
	String telNumber;
	String eMail;
	
	public ContactInfo() {
		
		homeAddress = null;
		telNumber = null;
		eMail = null;
		
	}
	
	public ContactInfo(String homeAddress, String telNumber, String eMail) {
		
		this.homeAddress = homeAddress;
		this.telNumber = telNumber;
		this.eMail = eMail;
		
	}
	
	public ContactInfo(ContactInfo contactInfo) {
		
        this(contactInfo.homeAddress, contactInfo.telNumber, contactInfo.eMail);
    }
	
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String toString() {
		
		return "Home Adress: " + getHomeAddress() + " |"+ " Tel Number: " + getTelNumber() + " |"+ " E-mail: " + geteMail();
		
	}
	
	public boolean equals(Object other) {
		
		if (other == null)
			return false;
		else if (this.getClass() != other.getClass())
			return false;
		else {
			
			ContactInfo contactInfo = (ContactInfo) other;
			
			return (this.getHomeAddress().equals(contactInfo.getHomeAddress()) && this.getTelNumber().equals(contactInfo.getTelNumber()) && this.geteMail().equals(contactInfo.geteMail()));
			
		}
	}


}
