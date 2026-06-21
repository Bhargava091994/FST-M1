package example;

import java.util.Scanner;

public class Activity13 {
	public void registerUser(String ageInput) {
		try {
			// Convert String to int
			int age = Integer.parseInt(ageInput);
 
			// Check age limit
			if (age < 18) {
				throw new IllegalArgumentException("Users must be at least 18 years old to register.");
			}
			// Print message
			System.out.println("Registration successful! Welcome aboard.");
 
		} catch (NumberFormatException e) {
			System.out.println("Registration Failed -> Error: Age must be a valid number.");
		} catch (IllegalArgumentException e) {
			// Catches the exception we explicitly threw above
			System.out.println("Registration Failed -> Error: " + e.getMessage());
		}
	}
 

	public static void main(String[] args) {
		// Accept input from user
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your age: ");
		String age = scan.nextLine();
 
		scan.close();
 
		// Pass the age to registerUser
		new Activity13().registerUser(age);
	}
}