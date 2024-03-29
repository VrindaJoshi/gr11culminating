// AVATAR OBJECT TEMPLATE CLASS

// class
public class Avatar {
	
	// fields
	private String name;
	private int age;
	private String gender;
	private String hairColor;
	
	// constructors
	public Avatar(String name, int age, String gender, String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hairColor = hairColor;
	}

	// getters + setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	// to string method
	@Override
	public String toString() {
		return "Avatar [name=" + name + ", age=" + age + ", gender=" + gender + ", hairColor=" + hairColor + "]";
	}
	
	
	
}


