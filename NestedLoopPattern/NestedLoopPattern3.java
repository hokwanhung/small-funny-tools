// I am just too tired to look at the codes now...maybe tomorrow
// But this codes uses no Math.abs()

public class NestedLoopPattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Either assign the middle "*" to the left side or to the right side.
		// Separate the graph into smaller parts and deal with it.
		/*
		 * Symmetric? FenGeFa(5+4/4+5)? Just consider the space in the range of dots?
		 * Consider the algorithm?
		 * *
		 * ***
		 * *****
		 * *******
		 * *********
		 * *******
		 * *****
		 * ***
		 * *
		 */
		// Math.abs() --> turn all integers into its absolute values.

		for (int i = 1; i <= 9; i++) { // indicate the no. of lines and the no. of spots.
			if (i <= 5) {
				for (int j = 0; j <= 9; j++) { // k: indicate the no. of symbols and spaces.
					if (j <= 5 - i) {
						System.out.print(" ");
					}
					if (j > 5 - i && j <= 2 * i - 1 + (5 - i)) {
						System.out.print("*");
					}

				}
			} else { // i >= 6 (6, 7, 8, 9)
				for (int k = 0; k <= 9; k++) {
					if (k <= i - 5) {
						System.out.print(" ");
					}
					if (k > i - 5 && k <= 14 - (i - 5) - i + (i - 5)) {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
	}
}
