/* This is one of the exercise I did when I started to learn programming.
   The whole class aims to find the biggest prime number between 1 and the user's input.
   The definition of prime number is that it can only be divisible by 1 and itself.
   This means that if the number(n) is divisible by other integers(i), it is not a prime number.
   n % i == 0, n is not a prime number.
   */ // 

import java.util.Scanner;

public class findPrimeNumber {

	public static void main(String[] args) {
		boolean isPrimeMain = false;
		int userInput;
		int biggestPrimeNumber;
		
		Scanner keyboardInput = new Scanner(System.in);
		
		System.out.println("Input a positive integer: ");
		userInput = keyboardInput.nextInt();
		biggestPrimeNumber = userInput;

		isPrimeMain = isPrime(biggestPrimeNumber); 
    // Check whether the input itself would be a prime number.
		
		while(isPrimeMain == false) {
			if (biggestPrimeNumber >= 1) {
      // Check whether other than the input, all integers below would be a prime number.
				biggestPrimeNumber--;
				isPrimeMain = isPrime(biggestPrimeNumber);
        // If the integer passed the method isPrime is a prime number, the flag becomes true.
        // Thus, the while loop ends.
			}
		}
		System.out.println("The biggest prime number between 1 to " + userInput + " is " + biggestPrimeNumber + ".");	
	}
	
	public static boolean isPrime(int testNumber) {
		boolean isPrime = true;
		double testTool = Math.floor(testNumber/2);
    // If the testTool > testNumber/2, there must be a remainder when testNumber modulus testTool.
		
		if (testTool <= 1) { 
    // When testNumber/2 >= 1, it means no available divisor other than 1. Thus, it must be a prime number.
			isPrime = true;
		} else {
			for (int i = (int)testTool; i > 1; i--) { 
      // The testing tool starts from back to forth, the last testing tool must be 2.
			// Though not intentionally, 2 is the most valuable tool to detect if it is a prime number.
				if (testNumber % i == 0) { // Assume every testNumber is a prime number first.
					isPrime = false;
				}  
			} // If the testNumber could be divisible by ANY number other than 1 or itself, it is not a prime number.
		}
		return isPrime;
	}
}
