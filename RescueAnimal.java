package grazioso;

/*
 * Project Two
 * Project while at Southern New Hampshire Universisty
 * Programmer: Jonathan Peterson 
 *
 * Version: 1.0
 * 
 * Description
 * File originally created by Southern New Hampshire University. Added an 
 * additional method for aestetics.
 *   
 * 
 * 
 */
public class RescueAnimal {

	// Instance variables
	private String name;
	private String animalType;
	private char gender;
	private int age;
	private double weight;
	private String acquisitionDate;
	private String acquisitionCountry;
	private String trainingStatus;
	private boolean reserved;
	private String inServiceCountry;

	// Empty Constructor
	public RescueAnimal() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public String getAcquisitionLocation() {
		return acquisitionCountry;
	}

	public void setAcquisitionLocation(String acquisitionCountry) {
		this.acquisitionCountry = acquisitionCountry;
	}

	public boolean getReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public String getInServiceLocation() {
		return inServiceCountry;
	}

	public void setInServiceCountry(String inServiceCountry) {
		this.inServiceCountry = inServiceCountry;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String status) {
		this.trainingStatus = status;
	}
	
	/**
	 * toStringInfo()
	 * 
	 * Displays info specific to reserving the dog. Displays it on the screen with
	 * color. The color for reserved will change if the value is true or false.
	 */

	public String toStringInfo() {
		StringBuilder sb = new StringBuilder();
		Controller con = new Controller();
		String colorCyan = "\u001B[36m"; // ANSI escape code for cyan color
		String colorReset = "\u001B[0m"; // ANSI escape code to reset color
		String colorRed = "\u001B[31m"; // ANSI escape code for red color
		String colorGreen = "\u001B[32m"; // ANSI escape code for green color

		// Append properties with appropriate colors
		sb.append(colorCyan).append("Name: ").append(colorReset).append(con.padRight(getName(), 10));
		sb.append(colorCyan).append(" Country Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionLocation(), 20));
		sb.append(colorCyan).append(" Training Status: ").append(colorReset)
				.append(con.padRight(getTrainingStatus(), 10));
		if (getReserved()) {
			sb.append(colorCyan).append(" Reserved: ").append(colorRed).append(con.padRight("true", 5));
		} else {
			sb.append(colorCyan).append(" Reserved: ").append(colorGreen).append(con.padRight("false", 5));
		}

		return sb.toString();
	}

}
