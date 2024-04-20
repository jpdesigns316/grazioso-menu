
package grazioso;

/*
 * Project Two
 * Project while at Southern New Hampshire Universisty
 * Programmer: Jonathan Peterson 
 *
 * Version: 1.0
 * 
 * Description
 * Monkey class that inherits the variables based on RescueAnimal with added funcions for aestetics.
 *   
 * 
 * 
 */
public class Monkey extends RescueAnimal {
	private static String species;
	private static double tailLength;
	private static double height;
	private static double bodyLength;

	public Monkey() {
		super();
		setSpecies("");
		setTailLength(0);
		setBodyLength(0);
		setHeight(0);
	}

	/**
	 * Full Construtor
	 * 
	 * @param name               Name of Monkey
	 * @param species            Species of Monkey
	 * @param gender             Gender of Monkey
	 * @param age                Age of Monkey
	 * @param weight             Weight of Monkey
	 * @param acquisitionDate    Date entered as Training Animal
	 * @param acquisitionCountry Country entered as Training Animal
	 * @param trainingStatus     Training Status
	 * @param reserved           If reserved or not
	 * @param inServiceCountry   Country service animal is in
	 * @param tailLength         Length of the tail
	 * @param height             Height of Monkey
	 * @param bodyLength         Length of Monkey
	 */
	public Monkey(String name, String species, char gender, int age, double weight, String acquisitionDate,
			String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
			double tailLength, double height, double bodyLength) {
		setName(name);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);

	}

	public static String getSpecies() {
		return species;
	}

	public static void setSpecies(String species) {
		Monkey.species = species;
	}

	public static double getTailLength() {
		return tailLength;
	}

	public static void setTailLength(double tailLength) {
		Monkey.tailLength = tailLength;
	}

	public static double getHeight() {
		return height;
	}

	public static void setHeight(double height) {
		Monkey.height = height;
	}

	public static double getBodyLength() {
		return bodyLength;
	}

	public static void setBodyLength(double bodyLength) {
		Monkey.bodyLength = bodyLength;
	}

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
		sb.append(colorCyan).append(" Species: ").append(colorReset).append(con.padRight(getSpecies(), 11));
		sb.append(colorCyan).append(" Gender: ").append(colorReset).append(con.padRight(getGender(), 5));
		sb.append(colorCyan).append(" Age: ").append(colorReset).append(con.padRight(getAge(), 5));
		sb.append(colorCyan).append(" Weight: ").append(colorReset).append(con.padRight(getWeight() + " lbs.\n", 10));
		sb.append(colorCyan).append("Tail Length: ").append(colorReset)
				.append(con.padRight(getTailLength() + " in. ", 10));
		sb.append(colorCyan).append("Body Length: ").append(colorReset)
				.append(con.padRight(getBodyLength() + " in. ", 10));
		sb.append(colorCyan).append("Height: ").append(colorReset).append(con.padRight(getHeight() + " in. ", 10));
		// Append colors based on reserved status
		sb.append(colorCyan).append("\nDate Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionDate(), 10));
		sb.append(colorCyan).append(" Country Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionLocation(), 10));
		if (getReserved()) {
			sb.append(colorCyan).append("Reserved: ").append(colorRed).append(con.padRight("true", 5));
		} else {
			sb.append(colorCyan).append("Reserved: ").append(colorGreen).append(con.padRight("false", 5));
		}

		// Append remaining properties
		sb.append(colorCyan).append(" In-Service Country: ").append(colorReset).append(getInServiceLocation());

		return sb.toString();
	}

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
		sb.append(colorCyan).append(" Species: ").append(colorReset).append(con.padRight(getSpecies(), 10));
		sb.append(colorCyan).append(" Country Aqcuired: ").append(colorReset)
				.append(con.padRight(getAcquisitionLocation(), 20));
		sb.append(colorCyan).append(" Training Status: ").append(colorReset)
				.append(con.padRight(getTrainingStatus(), 10));
		if (getReserved()) {
			sb.append(colorCyan).append(" Reserved: ").append(colorRed).append(con.padRight("true", 5));
		} else {
			sb.append(colorCyan).append(" Reserved: ").append(colorGreen).append(con.padRight("false", 5)).append(colorReset);
		}

		return sb.toString();
	}

}
