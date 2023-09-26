// Soo this is another classwork that my college requires me to do.
// The topic requires us to print out the following patterns in just 3 loops, with Math.abs() method suggested to use.
// First, let me list out the required pattern:
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
// The above diamond contains of 9 lines and at most 9 slots to obtain the "*".

// In this class, I listed out all opportunities and find out the common factors among them, with the "divide-and-conquer" method.
// Though, the answer provided below is nothing close to the perfect answer, but a demonstration of the method I used and how I first deal with it.
// Though it is probably not appriopriate to design such algorithm, not still a memorable piece of codes to my own work.

// To start with, it is much easier to plot a graph and look at it:
/* no. of lines --- no. of spaces --- no. of stars
 *      1       ---       4       ---      1
 *      2       ---       3       ---      3
 *      3       ---       2       ---      5
 *      4       ---       1       ---      7
 *      5       ---       0       ---      9
 *      6       ---       1       ---      7
 *      7       ---       2       ---      5
 *      8       ---       3       ---      3
 *      9       ---       4       ---      1
 */

// First, by looking at both the trends of no. of spaces and stars, both of them have their turning point on line 5.
// Noticeably, line 5 is also the middle point which is Math.ceil([no.ofLines]/2) or [no.ofLines]/2 + 1.
// It would be much more easier to find out the pattern as if we divide it into two patterns, i.e. i <= 5 and i>=6.
// This would be i <= Math.ceil([no.ofLines]/2) and i > Math.ceil([no.ofLines]/2) correspondingly.
// The i <= 5 pattern could be skipped from explanation.

// Let us start from discussing the no. of space first.
// The trend of the no. of spaces could be well explained by Math.abs(j - i) below.
// However, Math.abs() could only represents its absolute values in which is not enough for i >= 6 in this case.
// As "j--" is used, after i >=6, the value of Math.abs(j - i) would only becomes bigger, thus "> 0" is not appropriate anymore.
// The below graph could explain the algorithm:
/* no. of lines --- Initial value of Math.abs(j - i) --- Required (target) no. of spaces (to print out " " successfully)
 *      6       ---               1                  ---                           1 (1)
 *      7       ---               2                  ---                           3 (2, 3)
 *      8       ---               3                  ---                           5 (3, 4, 5)
 *      9       ---               4                  ---                           7 (4, 5, 6, 7)
// As a result, I set the algorithm to 2*(i - 5) - 1. ((i - 5) + 1 is also accpetable though.)

// Then let us discuss the no. of stars.
// The below graph could explain the algorithm:
/* no. of lines --- Relationship --- no. of stars
 *      1       ---      +0      ---      1
 *      2       ---      +1      ---      3
 *      3       ---      +2      ---      5
 *      4       ---      +3      ---      7
 *      5       ---      +4      ---      9
 *      6       ---      +1      ---      7
 *      7       ---      -2      ---      5
 *      8       ---      -5      ---      3
 *      9       ---      -8      ---      1
 */
// The change of relationship between the no. of lines and no. of stars from line 1 to 5 is +1.
// The change of relationship between the no. of lines and no. of stars from line 6 to 9 is -3.
// As a result, I set the algorithm to k <= i + (4 - 3*(i - 5)) in which 4 is the starting value of the line 5.
// (4 - 3*(i - 5)) would eventually become negative and perform the action that no. of lines minus the so called "Relationship"
// equals to no. of stars.

 public class printOutDiamondWith3LoopsSimpleVersion

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) { // Determines the no. of lines and spots
			for (int j = 5; (i <= 5 && j - i > 0) || (i >= 6 && (Math.abs(j - i) <= 2*(i - 5) - 1)) ; j--) {
				System.out.print(" "); // Determine the no. of " ".
			} 
			for (int k = 1; (i <= 5 && k <= 2*i - 1) || (i >= 6 && k <= i + (4 - 3*(i - 5))); k++) {
				System.out.print("*"); // Determine the no. of "*".
			}
			System.out.println();
		}
	}
}
