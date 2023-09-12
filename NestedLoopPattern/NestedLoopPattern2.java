public class NestedLoopPattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern1();
		System.out.println();
		pattern2();
		System.out.println();
		pattern3();
		System.out.println();
		pattern4();
	}

	// The secret is between the definition of the integers' values.
	/*
	 * Initialize = Initially
	 * condition = the numbers of actions
	 * increment = the trends (upward = "++"/ downward = "--")
	 * The reason assuring `i = 1` is because we know each line have at most 5
	 * spots.
	 */

	public static void pattern1() {
		for (int i = 1; i <= 5; i++) { // Define how many "*" and " " in each line.
			for (int j = 1; j <= i; j++) { // Print out "*".
				System.out.print("*");
			}
			for (int k = 4; k >= i; k--) { // Print out " ".
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pattern2() {
		for (int i = 1; i <= 5; i++) { // Define how many "*" and " " in each line.
			for (int j = 5; j >= i; j--) { // Print out "*".
				System.out.print("*");
			}
			for (int k = 2; k <= i; k++) { // Print out " ".
				// (SOOOO WEIRD) - Not weird, as we are trying to avoid printing " " in the
				// first line only.
				// The initialize of k determines how many lines of printing " " (action) to be
				// skipped.
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void pattern3() {
		for (int i = 1; i <= 5; i++) { // Define how many "*" and " " in each line.
			for (int j = 4; j >= i; j--) { // Print out " ".
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) { // Print out "*".
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void pattern4() {
		for (int i = 1; i <= 5; i++) { // Define how many "*" and " " in each line.
			for (int j = 2; j <= i; j++) { // Print out " ".
				System.out.print(" ");
			}
			for (int k = 5; k >= i; k--) { // Print out "*".
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
