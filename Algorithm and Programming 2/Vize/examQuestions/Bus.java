package examQuestions;

public class Bus extends Vehicle {
	
	int capacity;
	int ageOfBus;
	
	public Bus() {
		
		this.capacity = -1;
		this.ageOfBus = -1;
		
	}
	
	public Bus(int capacity, int ageOfBus, String Brand, String licencePlate, Person owner) {
		
		this.capacity = capacity;
		this.ageOfBus = ageOfBus;
		this.setBrand(Brand);
		this.setLicencePlate(licencePlate);
		this.setOwner(owner);
		
		
	}
	
	public Bus(Bus bus) {
		
        this(bus.getCapacity(), bus.getAgeOfBus(), bus.getBrand(), bus.getLicencePlate(), bus.getOwner());
			
	}
	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAgeOfBus() {
		return ageOfBus;
	}

	public void setAgeOfBus(int ageOfBus) {
		this.ageOfBus = ageOfBus;
	}

	@Override
	public int calculateTax() {
		
		if(ageOfBus < 5)
			return 4000;
		else if(ageOfBus >= 5 && ageOfBus <= 10)
			return 3000;
		else{
			return 2000;
		}
		
	}
	
	public String toString() {
		
		return "Brand: " + getBrand() + " |"+ " LicencePlate: " + getLicencePlate() + " |"+ " Capacity: " + getCapacity() + " |"+ " Age Of Bus: " + getAgeOfBus() + " |"+ " Owner: " + getOwner();
		
	}
	
	
	public boolean equals(Object other) {
		
		if (other == null)
			return false;
		else if (this.getClass() != other.getClass())
			return false;
		else {
			
			Bus bus = (Bus) other;
			
			return (this.getCapacity() == bus.getCapacity() && this.getAgeOfBus() == bus.getAgeOfBus());
			
		}
	}

	

}
