package example;

public class Activity3 {
	public String adjustDevice(String device, int value) {
		// Print message based on device
		String status = switch (device) {
		// Null case handler
		case null -> "Invalid device type.";
		// Guarded pattern matching
		case String d when d.equals("THERMOSTAT") && value > 40 -> "[Thermostat] Warning: Temperature high";
		// Standard case matching
		case "THERMOSTAT" -> "[Thermostat] Temperature is set to " + value;
		case "LIGHT" -> "[Light] Adjusting brightness to " + value + "%.";
		default -> "Unknown device given";
		};
		// Return the status message
		return status;
	}

	public static void main(String[] args) {
		// Create the call object
		Activity3 obj3 = new Activity3();

		// Call the adjustDevice
		System.out.println(obj3.adjustDevice("THERMOSTAT", 41));
		System.out.println(obj3.adjustDevice("THERMOSTAT", 25));
		System.out.println(obj3.adjustDevice("LIGHT", 50));
	}
}



