/**
 * 
 */
package challengeLeTour;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class StarterApp {

	private static final int PENALTY_TIME = 5;
	
	public static List<Rider> results = readInFromFileExcludingMicrosoftRiders();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int input;

		do {

			System.out.println("Please select an option");
			System.out.println("1. Show results - ordered by time (faster stage time first etc)");
			System.out.println("2. Update rider time (add 5 mins penalty) - using Matthew Collins as example");
			System.out.println(
					"3. Output to file (using separte Thread) all riders that are +30 minutes (inclusive) after the winners time. ");
			System.out.println("0. Quit");

			input = sc.nextInt();

			switch (input) {
			case 1:
				// Sort by time
				Collections.sort(results, new SortByTime());

				System.out.println("Race results");
				System.out.println();
				displayAllRiders();
				break;
			case 2:
				// Add 5 Minute Penalty to Matthew Collins
				addPenaltyToMatthewCollins();
				break;
			case 3:
				// Print cutoff riders (in separate thread)
				CutoffPrint cop = new CutoffPrint();
				Thread t1 = new Thread(cop);
				t1.start();
				break;
			case 0:
				System.out.println("Qutting - Have a good day!");
				break;
			default:
				System.out.println("Invalid choice, please choose again");
			}

		} while (input != 0);

	}

	/**
	 * This method adds a penalty of 5 minutes (constant) to Matthew Collins' time
	 */
	public static void addPenaltyToMatthewCollins() {
		for (Rider r : results) {
			if (r.getFirstName().contains("Matthew") || r.getLastName().contains("Collins")) {
				System.out.println("Matthew Collins");
				System.out.println("Arrival Time : " + r.getTime());
				LocalTime timetemp = r.getTime();
				r.setTime(timetemp.plusMinutes(PENALTY_TIME));
				System.out.println("Official Time (Arrivial Time + Penalty) : " + r.getTime());
			}
		}
	}

	/**
	 * This method display all rider in results - order will depend on preceeding
	 * comparator
	 */
	public static void displayAllRiders() {
		for (Rider r : results) {
			r.displayAllDetails();
		}
	}

	/**
	 * This method reads in the csv file creating Riders in an AL - it removes all
	 * Microsoft Riders
	 * 
	 * @return
	 */
	public static List<Rider> readInFromFileExcludingMicrosoftRiders() {
		List<Rider> results = new ArrayList<Rider>();

		results.clear();

		File file = new File("stage_results-1.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Reading header
			String line = br.readLine();

			// Read first line

			line = br.readLine();

			while (line != null) {

				String[] splitDetails = line.split(",");

				String firstName = splitDetails[0];
				String lastName = splitDetails[1];
				String nationality = splitDetails[2];
				String team = splitDetails[3];

				String[] time = splitDetails[4].split(":");
				LocalTime result = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
						Integer.parseInt(time[2]));

				if (!team.contains("Microsoft")) {
					results.add(new Rider(firstName, lastName, nationality, team, result));
				}
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

}
