package grazioso;

/*
 * Project Two
 * Project while at Southern New Hampshire Universisty
 * Programmer: Jonathan Peterson 
 *
 * Version: 1.0
 * 
 * Description
 * Dog file that inherits the variables based on RescueAnimal with added funcions for aestetics.
 *   
 * 
 * 
 */
import java.util.Scanner;

public class Dog extends RescueAnimal {

	// Variables that only refer to Dogs
	private String breed;

	/**
	 * Construtor
	 * 
	 * Default value's in RescueAnimal
	 */
	public Dog() {
		super();
		setName("");
		setBreed("");
		setGender(' ');
		setAge(0);
		setWeight(0.0);
		setAcquisitionDate("");
		setAcquisitionLocation("");
		setTrainingStatus("");
		setReserved(false);
		setInServiceCountry("");

	}

	/**
	 * Full Construtor
	 * 
	 * @param name               Name of Dog
	 * @param breed              Breed of Dog
	 * @param gender             Gender of Dog
	 * @param age                Age of Dog
	 * @param weight             Weight of Dog
	 * @param acquisitionDate    Date entered as Training Animal
	 * @param acquisitionCountry Country entered as Training Animal
	 * @param trainingStatus     Training Status
	 * @param reserved           If reserved or not
	 * @param inServiceCountry   Country service animal is in\
	 */
	public Dog(String name, String breed, char gender, int age, double weight, String acquisitionDate,
			String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setBreed(breed);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);

	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String dogBreed) {
		this.breed = dogBreed;
	}

	/**
	 * toString() override
	 * 
	 * This method formats data in columns and then displays it on the screen with
	 * color. The color for reserved will change if the value is true or false.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Controller con = new Controller();
		String colorCyan = "\u001B[36m"; // ANSI escape code for cyan color
		String colorReset = "\u001B[0m"; // ANSI escape code to reset color
		String colorRed = "\u001B[31m"; // ANSI escape code for red color
		String colorGreen = "\u001B[32m"; // ANSI escape code for green color

		// Append properties with appropriate colors
		sb.append(colorCyan).append("Name: ").append(colorReset).append(con.padRight(getName(), 10));
		sb.append(colorCyan).append(" Species: ").append(colorReset).append(con.padRight(getBreed(), 11));
		sb.append(colorCyan).append(" Gender: ").append(colorReset).append(con.padRight(getGender(), 5));
		sb.append(colorCyan).append(" Age: ").append(colorReset).append(con.padRight(getAge(), 5));
		sb.append(colorCyan).append(" Weight: ").append(colorReset).append(con.padRight(getWeight() + " lbs.", 10));

		// Append colors based on reserved status
		sb.append(colorCyan).append("\nDate Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionDate(), 10));
		sb.append(colorCyan).append(" Country Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionLocation(), 10));
		sb.append(colorCyan).append("\nTraining Status: ").append(colorReset)
				.append(con.padRight(getTrainingStatus(), 10));
		if (getReserved()) {
			sb.append(colorCyan).append(" Reserved: ").append(colorRed).append(con.padRight("true", 5));
		} else {
			sb.append(colorCyan).append(" Reserved: ").append(colorGreen).append(con.padRight("false", 5));
		}

		// Append remaining properties
		sb.append(colorCyan).append(" In-Service Country: ").append(colorReset).append(getInServiceLocation());

		return sb.toString();

	}

	/**
	 * toStringInfo()
	 * 
	 * Displays info specific to reserving the dog. Displays it on the screen with
	 * color. The color for reserved will change if the value is true or false.
	 */
	@Override
	public String toStringInfo() {
		StringBuilder sb = new StringBuilder();
		Controller con = new Controller();
		String colorCyan = "\u001B[36m"; // ANSI escape code for cyan color
		String colorReset = "\u001B[0m"; // ANSI escape code to reset color
		String colorRed = "\u001B[31m"; // ANSI escape code for red color
		String colorGreen = "\u001B[32m"; // ANSI escape code for green color

		// Append properties with appropriate colors
		sb.append(colorCyan).append("Name: ").append(colorReset).append(con.padRight(getName(), 10));
		sb.append(colorCyan).append(" Breed: ").append(colorReset).append(con.padRight(getBreed(), 10));
		sb.append(colorCyan).append(" Country Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionLocation(), 20));
		sb.append(colorCyan).append(" Training Status: ").append(colorReset)
				.append(con.padRight(getTrainingStatus(), 10));
		if (getReserved()) {
			sb.append(colorCyan).append(" Reserved: ").append(colorRed).append(con.padRight("true", 5));
		} else {
			sb.append(colorCyan).append(" Reserved: ").append(colorGreen).append(con.padRight("false", 5));
		}
		sb.append(colorReset);

		return sb.toString();
	}

}
