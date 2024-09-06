package challengeLeTour;

import java.time.LocalTime;

public class Rider {

	// Instance Variables

	private String firstName;
	private String lastName;
	private String nationality;
	private String team;
	private LocalTime time;

	// Constructor

	/**
	 * @param firstName
	 * @param lastName
	 * @param nationality
	 * @param team
	 * @param time
	 */
	public Rider(String firstName, String lastName, String nationality, String team, LocalTime time) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.team = team;
		this.time = time;
	}
	// Getters and Setters

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	} 
	
	// to String

	@Override
	public String toString() {
		return "Rider [firstName=" + firstName + ", lastName=" + lastName + ", nationality=" + nationality + ", team="
				+ team + ", time=" + time + "]";
	}
	
	// Methods
	
	public void displayAllDetails() {
		System.out.println("Name : " + getFirstName() + " " + getLastName());
		System.out.println("Team : " + getTeam());
		System.out.println("Nat  : " + getNationality());
		System.out.println("Time : " + getTime());
		System.out.println();
		
	}
	
	

}
