// Finally it is time for the advanced version of my classwork.
// The topic requires us to print out a diamond with 9 lines in just 3 loops, with Math.abs() method suggested to use.
// In this advanced program, the lines of the diamond is based on user inputs, though odd inputs are required.
// However, I did not use any Math.abs() method in this program. Instead, multiple mathematicis equations are used.

// It is also much more simple to explain it with an example.
// Take a diagram with 9 lines as an example. (Though I did use diamonds with different lines to test the equations.)
/*     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 */

// Let divide the diagram into two parts, one is lines with increasing "*" and one is with decreasing "*".
// The first equation we need to know is the no. of the specific line that seperates both parts:
// maxNumberOfLines/2 + 1(consider maxNumberOfLines as an int) or math.ceil(maxNumberOfLines/2)(consider maxNumberOfLines as a double).

// The second equation would be about considering the no. of slots.
/* no. of lines --- no. of spaces --- no. of stars --- total no. of slots (Using 9 lines as an example)
 *       1                4                 1                  5
 *       2                3                 3                  6
 *       3                2                 5                  7
 *       4                1                 7                  8
 *       5                0                 9                  9
 *       6                1                 7                  8
 *       7                2                 5                  7
 *       8                3                 3                  6
 *       9                4                 1                  5
 */
// The idea is simple, if we can find the no. of slots and the no. of spaces in each line.
// The no. of stars could be easily arranged by filling the leftover slots.
// By considering the no. of slots, line 1 - 5 and line 6 - 9 can be separated two separate groups(i.e. middleLine).
// The equation of no. of slots for the first half part would be :
// numberOfLines(i.e. i) + (middleLine - 1)
// where middleLine - 1 would be 4 at this point(when the maxNumberOfLines = 9).
// The equation of no. of slots for the last half part would be:
// middleLine(i.e. as a replacement of i) + (middleLine - 1)(i.e. same as the above) - (i - middleLine)
// where i - Math.ceil(maxNumberOfLines/2) would be -1 when i = 6(i.e. when the numberOfLines = 6).

// And for the no. of spaces:
// The first half would be middleLine - i.
// The second half would be i - middleLine.
// The equation of the two halves are exactly in a negative relationship(or symmetrical regarding their slopes).

// And this is how I finished the "print out diamond in 3 for loops" classwork.

import java.util.Scanner;

public class printOutDiamondWith3LoopsAdvancedVersion {

	public static void main(String[] args) {
		
		int userInput = 0;
		boolean isValidFlag = false;
	
		Scanner keyboardInput = new Scanner(System.in);
		
		// Request to user inputs of the no. of lines.
		System.out.println("This program is used to print out a diagram of diamond.");	
		while (isValidFlag == false) {
			System.out.println("Please insert the no. of lines that you want to used(must be a odd number):");
			userInput = keyboardInput.nextInt();
			if (userInput % 2 == 1 && userInput >= 3) {
				isValidFlag = true; // maxNumberOfLines is an odd number and it's bigger than 3.
			} 
		} 
		// If an even number is inserted or the number inserted is lower than 3, the user is requested to input another number.
	
		double maxNumberOfLines = userInput;
		// double type is used instead of integer type in order to prevent removal of remainder when a division performed.
		double middleLine = Math.ceil(maxNumberOfLines/2);
		
		// Print out the diamond.
		for (int i = 1; i <= maxNumberOfLines; i++) { 
  		// Determine the number of lines, which is also the maximum number of slots (the line in the middle).
			if (i <= middleLine) { // Seperate the whole diamond into two parts(as mentioned above).
				for (int j = 1; j <= i + (middleLine - 1)); j++) {
					// Determine the no. of slots in each line from line 1 to 5.
					if (j <= middleLine - i) { // Determine the no. of spaces and stars.
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			} else { // i > Math.ceil(numberOfLines/2)
				for (int k = 1; k <= (middleLine + (middleLine - 1)) - (i - middleLine); k++) {
					// For better understanding, I did not simplify the above condition, which of course could be more simple.
					// Determine the no. of slots in each line from line 6 to 9.
					if (k <= i - middleLine) { // Determine the no. of spaces and stars.
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
			} 
			System.out.println();	
		}
    
	}
}
