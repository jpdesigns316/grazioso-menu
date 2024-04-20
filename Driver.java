package grazioso;

/*
 * Project Two
 * Project while at Southern New Hampshire Universisty
 * Programmer: Jonathan Peterson 
 *
 * Version: 1.0
 * 
 * Description
 * Main class to run the program. 
 * - Intake a new dog or monkey with validation on input as well as checking to see if the dog or monkey already exists in the database.
 * - Reseve an dog or monkey. Will only display ones that have passed the training and are not reserved.
 * - Print information about the dog or monkey
 * 
 * FUTURE UPADATE
 * Possible conversion to a GUI
 * SQL connections to save database information in case of program crash.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	private static ArrayList<Dog> dogList = new ArrayList<>(); // Dog database
	private static ArrayList<Monkey> monkeyList = new ArrayList<>(); // Monkey Database
	private static int choice;
	private static String[] menuOptions = { "+---------------------------------------------------------+",
			"|                  MAIN   MENU                            |",
			"+---------------------------------------------------------+",
			"|  [1] Intake a new dog                                   |",
			"|  [2] Intake a new monkey                                |",
			"|  [3] Reserve an animal                                  |",
			"|  [4] Print info on animal                               |",
			"|  [5] Quit application                                   |",
			"|                                                         |",
			"|  Enter a menu selection                                 |",
			"+---------------------------------------------------------+"

	};

	private static String[] printOptions = { "+---------------------------------------------------------+",
			"|                  PRINT  MENU                            |",
			"+---------------------------------------------------------+",
			"|  [1] Print List of All Dogs                             |",
			"|  [2] Print List of All Monkeys                          |",
			"|  [3] Available Animals                                  |",
			"|  [4] Return to Main Menu                                |",
			"|  [5] Quit application                                   |",
			"|                                                         |",
			"|  Enter a menu selection                                 |",
			"+---------------------------------------------------------+"

	};

	private static String[] listOfTrainingStatus = { "Phase I", "Phase II", "Phase III", "Phase IV", "Phase V",
			"in-service", "farm",

	};

	public static void main(String[] args) {

		initializeDogList();
		initializeMonkeyList();
		displayMenu("main");

	}

	/**
	 * Display a menu with options for the user to navigate. Future updates will be
	 * moved to Conrtoller
	 *
	 * @param type The type of menu that is to be displayed.
	 */
	public static void displayMenu(String type) {
		Controller con = new Controller();
		Scanner input = new Scanner(System.in);
		int width = 80;
		String centeredMenu;
		/**
		 * Display the type of menu that is to be displayed.
		 * 
		 * @param main    Main Menu
		 * @param print   Print Menu with options to print information about the
		 *                animal(s)
		 * @param reserve Reserve Menu of animal not reserved, in-training, or living on
		 *                the farm
		 */
		switch (type) {
		case "main":
			for (String menuOption : menuOptions) {
				centeredMenu = con.centerText(menuOption, width);
				System.out.println(centeredMenu);
			}
			try {
				choice = con.readInt("Enter Your Option :> ", input, 1, 7);
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				displayMenu("main");
			}
			switch (choice) {
			case 1:
				intakeNewDog(input);
				break;
			case 2:
				intakeNewMonkey(input);
				break;
			case 3:
				reserveAnimal(input);
				break;
			case 4:
				displayMenu("print");
				break;
			case 5:
				System.out.println("Exiting program");
				System.exit(0);
				break;
			}
			break;

		case "print":
			for (String printOption : printOptions) {
				centeredMenu = con.centerText(printOption, width);
				System.out.println(centeredMenu);
			}
			try {
				choice = con.readInt("Enter Your Option :> ", input, 1, 5);
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
				displayMenu("main");
			}
			switch (choice) {
			case 1:
				printDogs();
				break;
			case 2:
				printMonkeys();
				break;
			case 3:
				printAnimals("available");
				break;
			case 4:
				notReserved();
				break;
			case 5:

				System.out.println("Exiting program");
				System.exit(0);
				break;
			}
			break;
		}

	}

	/*
	 * Prints a information on the dogs based on the information requested.
	 * 
	 */
	// Example:
	// Name Breed Gender Age Weight
	// Spot German Shepherd M 1 25.6
	// Rex Great Dane M 3 35.2
	// Bella Chihuahua F 4 25.6

	private static void printDogs() {
		Controller con = new Controller();

		for (Dog dog : dogList) {
			System.out.println(dog.toString());
			System.out.println("--------------------------------------------------------------------------");
		}
		displayMenu("print");

	}

	/*
	 * Prints a information on the monkeys based on the information requested.
	 */
	private static void printMonkeys() {

		System.out.println("------------------------------------------------------------------------");
		for (Monkey monkey : monkeyList) {
			System.out.println(monkey.toString());
			System.out.println("------------------------------------------------------------------------");
		}
		displayMenu("print");

	}

	/*
	 * Prints a information on the dog and monkeys that have not been reserved.
	 */
	private static void notReserved() {
		System.out.println("Monkeys Availble:");
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		for (Monkey monkey : monkeyList) {
			if (!monkey.getReserved() && monkey.getTrainingStatus() == "in service") {
				System.out.println(monkey.toStringInfo());
				System.out.println(
						"--------------------------------------------------------------------------------------------");
			}
		}
		System.out.println("Dogs Availble:");
		for (Dog dog : dogList) {
			if (!dog.getReserved() && dog.getTrainingStatus() == "in service") {
				System.out.println(dog.toStringInfo());
				System.out.println("------------------------------------------------------------------------\n\n");
			}
		}

		displayMenu("main");

	}

	/*
	 * Adds dogs to a list for testing FUTURE RELEASES WILL USE MySQL on Windows or
	 * PostgreSQL on Linux
	 *
	 */
	public static void initializeDogList() {
		Dog dog1 = new Dog("Spot", "German Shepherd", 'M', 1, 25.6, "2019-12-05", "United States", "in service", false,
				"United States");
		Dog dog2 = new Dog("Rex", "Great Dane", 'M', 3, 35.2, "2020-03-2020", "United States", "Phase I", false,
				"United States");
		Dog dog3 = new Dog("Bella", "Chihuahua", 'F', 4, 25.6, "2019-12-12", "Canada", "in service", true, "Canada");
		Dog dog4 = new Dog("Zita", "Boxer", 'F', 2, 23.7, "2017-10-04", "Russia", "in service", false, "Ukraine");

		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
		dogList.add(dog4);
	}

	/*
	 * Adds monkeys to a list for testing FUTURE RELEASES WILL USE MySQL on Windows
	 * or PostgreSQL on Linux
	 *
	 *
	 * 
	 * public Monkey(String name, String species, char gender, int age, double
	 * weight, String acquisitionDate, String acquisitionCountry, String
	 * trainingStatus, boolean reserved, String inServiceCountry, double tailLength,
	 * double height, double bodyLength)
	 */
	public static void initializeMonkeyList() {
		Monkey monkey1 = new Monkey("Bob", "Marmoset", 'F', 6, 12.4, "2021-12-15", "U.S.A", "Phase II", false, "U.S.A",
				3.1, 2.4, 4);
		Monkey monkey2 = new Monkey("Kit", "Squirrel monkey", 'M', 3, 10.4, "2022-05-15", "U.S.A", "in service", false,
				"U.S.A", 3.1, 2.4, 4);
		Monkey monkey3 = new Monkey("Bob", "Marmoset", 'F', 6, 12.4, "2021-12-15", "U.S.A", "Phase II", false, "U.S.A",
				3.1, 2.4, 4);
		monkeyList.add(monkey1);
		monkeyList.add(monkey2);
		monkeyList.add(monkey3);
	}

	/**
	 * Intake a dog into the database getting information about a dog. Also check to
	 * see if the dog is already in the database
	 *
	 * @param input Scanner
	 */
	public static void intakeNewDog(Scanner input) {
		Controller con = new Controller();
		Object[] gettingDogInfo = { "Enter name: ", "Enter breed", "Enter gender: ", "Enter age: ",
				"Enter weight (0.0): ", "Enter acquisiton date (only accepting animals older than 2 years old):  ", "Enter acquisition country: ",
				"Enter training status: ", "Enter Reservation Status (true/false): ", "Enter In-Service Country: " };

		Object[] dogInfo = new Object[10];
		String name = "";
		String trainingStatus = "";
		boolean isEligible = false; // This is needed to check if the input is contained in a list of available options
		boolean isValid = false; // This is needed for input validation

		double number = 0.0;
		
		System.out.println("Enter dog's name: ");
		input.nextLine();
		name = input.nextLine();
		con.findAnimalByName(name, dogList);
		dogInfo[0] = name;
		/*
		 * Access the gettingDogInfo to get questions that are required for intaking the
		 * dog. A switch case is used to get valid information. This information is
		 * stored in an object array that is used put in the Dog array.
		 *
		 */
		for (int i = 1; i < gettingDogInfo.length; i++) {
			System.out.println(gettingDogInfo[i]);
			switch (i) {
			case 1: // Breed
			case 2: // Gender
			case 6: // Acquistition Country
			case 9: // InService Country
				dogInfo[i] = input.nextLine();
				break;
			case 3: // Age
				do {
					try {
						number = input.nextInt();
						if (number <= 0) {
							System.out.println("Input must be greater than 0.");
						} else {

							isValid = true;
							dogInfo[i] = (int) number;
							System.out.println(dogInfo[i].getClass().getSimpleName());
						}
					} catch (InputMismatchException e) { // If a non-double/integer is
															// entered then catch an
															// InputMismatchException and
															// ask the statment again
						System.out.println("Enter a valid number.");
						input.nextLine(); // consume line
					}
				} while (!isValid);

				input.nextLine();
				break;
			case 4: // Weight
				try {
					dogInfo[i] = input.nextDouble();

				} catch (InputMismatchException e) {
					System.out.println("Invalid input."); // if input is invalid decrement i to ask question again
					i--;
				}
				break;
			case 5: //Acquistition Date
				dogInfo[i] = con.assignDate(input);
				input.nextLine();
				break;
			case 7: // Training Status
				System.out.println("Availible Training Status");
				for (int j = 0; j < listOfTrainingStatus.length; j++) {
					System.out.println(listOfTrainingStatus[j]);
				}
				isEligible = false;
				while (!isEligible) {
					trainingStatus = input.nextLine();
					isEligible = Arrays.asList(listOfTrainingStatus).contains(trainingStatus);
					if (!isEligible) {
						System.out.println("Invalid training status. Please try again.");
					} else {
						dogInfo[i] = trainingStatus;
						isEligible = true;
					}
					
				}
				break;
			case 8: // Is dog reserved with error-checking to get valid input
				try {
					if(dogInfo[7] == "in-service") {
						dogInfo[i] = input.nextBoolean();
					} else {
						System.out.println("Animal cannot be reserved.");
						dogInfo[i] = false;
					}
					input.nextLine(); // Consume newline character
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter 'true' or 'false'.");
					input.nextLine(); // Consume newline character
					i = 7;
				}
				break;
			}
		}
		/*
		 *
		 * Dog(String name, String breed, char gender, int age, double weight, String
		 * acquisitionDate, String acquisitionCountry, String trainingStatus, boolean
		 * reserved, String inServiceCountry)
		 */
		
		;
		Dog intakeDog = new Dog((String) dogInfo[0], (String) dogInfo[1], ((String) dogInfo[2]).charAt(0),
		        (int) dogInfo[3], (double) dogInfo[4], (String) dogInfo[5], (String) dogInfo[6], (String) dogInfo[7],
		        (boolean) dogInfo[8], (String) dogInfo[9]);

		dogList.add(intakeDog);
		displayMenu("main");

	}

	/**
	 * Intake a monkey into the database getting information about a monkey. Also
	 * check to see if the monkey is already in the database
	 *
	 * @param input Scanner
	 */
	public static void intakeNewMonkey(Scanner input) {
		Controller con = new Controller();
		String[] eligableSpecies = { "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin" };
		boolean isEligible = false;
		int number;
		boolean isValid = false;
		String name = "";
		String species = "";
		String trainingStatus = "";
		// Object array to asks questions for the database
		Object[] gettingMonkeyInfo = { "Enter name: ",
				"Enter species (Supported species: Capuchin, Guenon, Macaque, Marmoset): ", "Enter gender: ",
				"Enter age: ", "Enter weight (lbs) (0.0): ", "Enter acquisiton date: (only accepting animals older than 2 years old): ",
				"Enter acquisition country: ", "Enter training status: ", "Enter Reservation Status (true/false): ",
				"Enter In-Service Country: ", "Enter tail length (in): ", "Enter Height (in): ",
				"Enter Body Length (in): " };

		Object[] monkeyInfo = new Object[13]; // fixed array size to store answers in to add to the Monkey object
		System.out.println("Enter monkey's name: ");
		input.nextLine();
		name = input.nextLine();
		con.findAnimalByName(name, monkeyList); // check to see if monkey exists in the Monkey database
		monkeyInfo[0] = name; // store name into the first index to stat to intake a new monkey

		/*
		 * Access the gettingDogInfo to get questions that are required for intaking the
		 * monkey. A switch case is used to get valid information. This information is
		 * stored in an object array that is used put in the Dog array.
		 *
		 */
		for (int i = 1; i < gettingMonkeyInfo.length; i++) {
			System.out.println(gettingMonkeyInfo[i]);
			switch (i) {
			case 2: // Gender
			case 6: // AcquistionCountry
			case 9: // In-service country
				monkeyInfo[i] = input.nextLine();
				break;
			case 5: // Acquistition Date
					// used assignDate in Controller to format and put a valid date.
				monkeyInfo[i] = con.assignDate(input);
				input.nextLine();
				break;

			case 7: // Training Status
				System.out.println("Availible Training Status");
				for (int j = 0; j < listOfTrainingStatus.length; j++) {
					System.out.println(listOfTrainingStatus[j]);
				}
				isEligible = false;
				while (!isEligible) {
					trainingStatus = input.nextLine();
					isEligible = Arrays.asList(listOfTrainingStatus).contains(trainingStatus);
					if (!isEligible) {
						System.out.println("Invalid training status. Please try again.");
					} else {
						monkeyInfo[i] = trainingStatus;
						isEligible = true;
					}
					
				}
				break;
			case 1: // Enter Species and validate if the species is supported.
				while (!isEligible) {
					species = input.nextLine();
					isEligible = Arrays.asList(eligableSpecies).contains(species);
					if (!isEligible) {
						System.out.println("Species is not supported.");
					} else {
						monkeyInfo[i] = species;
						isEligible = true;
					}

				}
				break;
			case 3: // Age
				// used assignDate in Controller to format and put a valid date.
				do {
					try {
						number = input.nextInt();
						if (number <= 0) {
							System.out.println("Input must be greater than 0.");
						} else {

							isValid = true;
							monkeyInfo[i] = (int) number;

						}
					} catch (InputMismatchException e) { // If a non-double/integer is
															// entered then catch an
															// InputMismatchException and
															// ask the statment again
						System.out.println("Enter a valid number.");
						input.nextLine(); // consume line
					}
				} while (!isValid);

				input.nextLine();
				break;
			case 4: // weight
			case 10: // Tail length
			case 11: // Height
			case 12: // Body length
				try {
					monkeyInfo[i] = input.nextDouble();

				} catch (InputMismatchException e) {
					System.out.println("Invalid input."); // if input is invalid decrement i to ask question again
					i--;
				}

				input.nextLine(); // consume line
				break;

			case 8: // is monkey reserved
				try {
					if(monkeyInfo[7] == "in-service") {
						monkeyInfo[i] = input.nextBoolean();
					} else {
						System.out.println("Animal cannot be reserved.");
						monkeyInfo[i] = false;
					}
					input.nextLine(); // Consume newline character
				} catch (Exception e) {
					System.out.println("Invalid input. Please enter 'true' or 'false'.");
					input.nextLine(); // Consume newline character
					i = 7;
				}
				break;		}
		/*
		 *
		 * public Monkey(String name, String species, char gender, int age, double
		 * weight, String acquisitionDate, String acquisitionCountry, String
		 * trainingStatus, boolean reserved, String inServiceCountry, double tailLength,
		 * double height, double bodyLength)
		 */

		Monkey intakeMonkey = new Monkey((String) monkeyInfo[0], (String) monkeyInfo[1],
		        ((String) monkeyInfo[2]).charAt(0), (int) monkeyInfo[3], (double) monkeyInfo[4],
		        (String) monkeyInfo[5], (String) monkeyInfo[6], (String) monkeyInfo[7], (boolean) monkeyInfo[8],
		        (String) monkeyInfo[9], (double) monkeyInfo[10], (double) monkeyInfo[11], (double) monkeyInfo[12]);
		monkeyList.add(intakeMonkey);
		displayMenu("main");
	}

	/**
	 * This method uses the Controller funtion findAnimalByReserved to check to see
	 * if the pet can be reserved.
	 * 
	 * @param input Scanner object to get input
	 */
	public static void reserveAnimal(Scanner input) {
		String choice = "";
		String name = "";
		Controller con = new Controller();
		System.out.println("Enter 'dog' to reserve a dog and 'monkey' to reserve a monkey: ");
		choice = input.next();

		switch (choice) {
		case "dog":

			System.out.println("Enter the name of the dog you which to reserve: ");
			name = input.next();
			con.findAnimalByReserved(name, dogList);
		case "monkey":

			System.out.println("Enter the name of the dog you which to reserve: ");
			name = input.next();
			con.findAnimalByReserved(name, monkeyList);

		}

		displayMenu("main");

	}

	/**
	 * + Print the Name, Breed, Training Status, Acquisition County and Reserved
	 * 
	 * @param type the type of animal you want a list on
	 */
	public static void printAnimals(String type) {
		Controller con = new Controller();
		switch (type) {
		case "dog":
			System.out.println("Dogs\n");
			con.printAnimalInfo(dogList, false);
			displayMenu("print");
			break;
		case "monkey":
			System.out.println("Monkeys\n");
			con.printAnimalInfo(monkeyList, false);
			displayMenu("print");
			break;
		case "available":
			System.out.println("Animals available\n");
			con.printAnimalInfo(dogList, true);
			con.printAnimalInfo(monkeyList, true);
			displayMenu("print");
			break;
		default:
			displayMenu("print");
			break;
		}

	}

}

/*
 * Controller class This class is created for helper methods. Later to be
 * implemented as a seperate file.
 */
class Controller {

	public Controller() {

	}

	/**
	 * Set padding to create columns for the information that is requested. This is
	 * written for future use and is boiler plate code which could be modified as
	 * needed.
	 * 
	 * @param input The String that is to be diplayed
	 * @param width The width of the column
	 * @return Text with a fixed width
	 */
	public String padRight(Object input, int width) {
		if (input instanceof String || input instanceof Character) {
			return String.format("%-" + width + "s", input);
		}
		if (input instanceof Integer) {
			return String.format("%-" + width + "d", input);
		} else {
			throw new IllegalArgumentException("Unsupported input type");
		}

	}

	/**
	 * Input validation for a range of characters. This can be used in a number
	 * guessing game or having a menu and have numbers as options. Validation makes
	 * sure a number in that range is entered, else it asks for a valid input.
	 *
	 * @param prompt The string which tells the user to enter a double
	 * @param key    the variable is Scanner is assigned to
	 * @param lower  the lowest number which will be acceptable
	 * @param upper  the highest number which will be acceptable
	 * @return true if the number enters is between the lower and upper
	 */
	public static int readInt(String prompt, Scanner input, int lower, int upper) {
		int result;
		boolean isNotValid;

		do {
			System.out.print(prompt);
			result = input.nextInt();
			isNotValid = (result < lower) || (result > upper);
			if (isNotValid) {
				System.out.println("ERROR: please enter value between " + lower + " - " + upper);
			}
		} while (isNotValid);

		return result;
	}

	/**
	 * Center a String or Sting array so that it is in the center of the range. The
	 * range can be set to the length of the screen or a set range that you want to
	 * be centered.
	 *
	 * @param text  The text that is to be displayed
	 * @param width The width of the screen
	 * @return The text in middle of the screen based on the width
	 */
	public static String centerText(String text, int width) {

		int padding = (width - text.length()) / 2;

		return String.format("%" + (padding + text.length()) + "s", text);
	}

	/**
	 * Search a child Rescue Animal to see if a name exists
	 * 
	 * @param <T>  Generic Type Parameter
	 * @param name the name of the animal
	 * @param list The Dog or Monkey child object that is to be searched.
	 */
	public static <T extends RescueAnimal> void findAnimalByName(String name, ArrayList<T> list) {
		Driver view = new Driver();
		for (T animal : list) {
			if (animal.getName().equalsIgnoreCase(name)) {
				System.out.println("\n\nThis " + animal.getClass().getSimpleName().toLowerCase()
						+ " is already in our system. Returning to main menu.\n\n");
				Driver.displayMenu("main");
				return; // Exit the method after finding the animal
			}
		}
	}

	/**
	 * Search a child Rescue Animal to see if a name exists
	 * 
	 * @param <T>  Generic Type Parameter
	 * @param name the name of the animal
	 * @param list The Dog or Monkey child object that is to be searched.
	 */
	public static <T extends RescueAnimal> void findAnimalByReserved(String name, ArrayList<T> list) {

		for (T animal : list) {
			if (!animal.getReserved() && animal.getName().equals(name)) {
				if (animal.getTrainingStatus() == "intake") {
					animal.setReserved(true);
					animal.setTrainingStatus("in service");
					System.out.println(name + " is now reserved.");
					return;
				}
			}
		}
		System.out.println(name + " is not availible to be reserved.");
	}

	/**
	 * Print the animals that are available to be reserved by going thought a
	 * RescueAnimal child ArrayList and checking the status of reserved and training
	 * status.
	 * 
	 * @param <T>   The generic type for ArrayList
	 * @param list  The ArrayList object that has that infomation that you want to
	 *              lookup
	 * @param avail If the RescueAnimal is available to be reserved.
	 */
	public static <T extends RescueAnimal> void printAnimalInfo(ArrayList<T> list, boolean avail) {
		if (!avail) {
			for (T animal : list) {
				System.out.println(animal.toStringInfo());
			}
		} else if (avail) {
			for (T animal : list) {
				if (!animal.getReserved() && animal.getTrainingStatus() == "in service") {
					System.out.println(animal.toStringInfo());
				}
			}
		}

	}
	/**
	 * Asks for month,date an year and formats them
	 * @param input Scanner
	 * @return MM-DD-YYYY
	 */
	
	public String assignDate(Scanner input) {
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int last_day = 31;
		String date = "";
		int month = 1;
		int day = 1;
		int year = 2000;
		month = readInt("Enter month the animal was acquired: ", input, 1, 12);
		last_day = daysInMonth[month-1];
		day  = readInt("Enter day the animal was acquired: ", input, 1, last_day);
		year = readInt("Enter year the animal was acquired (2000-2020): ", input, 2000, 2020);
		date =  year + month + "-" + day;
		System.out.println(date);
		return date;
		
	}

}
