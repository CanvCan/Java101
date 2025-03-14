package algoProject;

public class Actor {
	
	String name;
	String gender;
	String nationality;
	
	public Actor(String name, String gender, String nationality) {
		super();
		this.name = name;
		this.gender = gender;
		this.nationality = nationality;
	}
	
	public Actor() {
		super();
		this.name = "KaanMuratCan";
		this.gender = "Erkek";
		this.nationality = "TR";
	}
	
	public Actor(Actor actor) {   // copy constructor
        this(actor.getName(), actor.getGender(), actor.getNationality());     
        
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Name: " + name + " |" + " Gender: " + gender + " |" + " Nationality: " + nationality;
	}
	
	
	
}
