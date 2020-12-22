public class NestedLoopPattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pattern1();
		System.out.println();
		pattern2();
		System.out.println();
		pattern3();
		System.out.println();
	}
	
	public static void pattern1() {
		System.out.println("Pattern 1");
		for (int i = 0; i <= 4; i++) {  // Define how many numbers are in every line.
			for (int j = 0; j <= i; j++) {
				System.out.print(j+1); // Define the values of every number.
			}
			System.out.println();
		}	
	}
	
	public static void pattern2() {
		System.out.println("Pattern 2");
		for (int i = 1; i <= 9; i++) { // Define the number to multiply the target.
			for (int j = 1; j <= 9; j++) {
				System.out.print((j*i) + " "); // Define the target to be multiplied.
			}
			System.out.println();
		}
	}
	
	public static void pattern3() {
		int integerStored=0;
		System.out.println("Pattern 3");
		for (int i = 1; i <= 5; i++) { // Define how many numbers are in every line.
			for (int j = 1; j <= i; j++) {
				System.out.print((integerStored+j) + " "); // Define the target to be added.
			}
			System.out.println();
			integerStored+=i; // Actual target with calculation.
		}
	}
}
