package examQuestions;

public class Demo {

	public static void main(String[] args) {
		
		ContactInfo contactInfo = new ContactInfo("Bornova/İzmir", "05326881626", "aliveli@gmail.com");
		Person person = new Person("Ali", contactInfo);
		Bus bus = new Bus(100, 12, "Audi", "10 CANBA 08", person);
	
		System.out.println(bus);
		System.out.println("Ödemeniz gereken vergi miktarı: " + bus.calculateTax() + " TL");
		
		Bus bus2 = new Bus(bus);
		
		System.out.println(bus.equals(bus2));

	}

}
