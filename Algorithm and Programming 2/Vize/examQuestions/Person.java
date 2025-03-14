package examQuestions;

public class Person {
	
	private String name;
	private ContactInfo contactInfo;
	
	public Person() {
		
		this.name = null;
		this.contactInfo = null;
		
	}
	
	public Person(String name, ContactInfo contactInfo) {
		
		this.name = name;
		this.contactInfo = new ContactInfo(contactInfo);
		
	}
	
	public Person(Person person) {
        this(person.getName(), person.getContactInfo());      

    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContactInfo getContactInfo() {
		return new ContactInfo(contactInfo);
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = new ContactInfo(contactInfo);
	}

	public String toString() {
		
		return "Name ---> " + getName() + ", ContactInformation ---> " + getContactInfo();
		
	}
	
	public boolean equals(Object other) {
		
		if (other == null)
			return false;
		else if (this.getClass() != other.getClass())
			return false;
		else {
			
			Person person = (Person) other;
			
			return (this.getName().equals(person.getName()) && this.getContactInfo().equals(person.getContactInfo()));
			
		}
	}

}
