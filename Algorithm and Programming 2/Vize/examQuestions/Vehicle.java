package examQuestions;

public abstract class Vehicle {
	
	private String brand;
	private String licencePlate;
	private Person owner;
	
	public Vehicle() {
		
		this.brand = null;
		this.licencePlate = null;
		this.owner = null;
	}
	
	public Vehicle(String brand, String licencePlate, Person owner) {
		
		this.brand = brand;
		this.licencePlate = licencePlate;
		this.owner = owner;
	
	}
	
	
	public Vehicle(Vehicle vehicle) {
		
        this(vehicle.getBrand(), vehicle.getLicencePlate(), vehicle.getOwner());
			
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public Person getOwner() {
		return new Person(owner);
	}

	public void setOwner(Person owner) {
		this.owner = new Person(owner);
	}
	
	public String toString() {
		
		return "Brand: " + getBrand() + " LicencePlate: " + getLicencePlate() + "Owner: " + getOwner();
		
	}
	
	public boolean equals(Object other) {
		
		if (other == null)
			return false;
		else if (this.getClass() != other.getClass())
			return false;
		else {
			
			Vehicle vehicle = (Vehicle) other;
			
			return (this.getBrand().equals(vehicle.getBrand()) && this.getLicencePlate().equals(vehicle.getLicencePlate()) && this.getOwner().equals(vehicle.getOwner()));
			
		}
	}
	
	public abstract int calculateTax();
	

}
