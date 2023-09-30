package FindPrime;
import java.io.*;
import java.util.*;

public class findPrimeNumber {
   public static void main(String[] args) {
      int userInput = 148592; // data example = 148592
      System.out.print("The largest prime factor of 148592 is ");
      System.out.println(maxPrimeFactors(userInput));
      userInput = 890654; // data example = 890654
      System.out.print("The largest prime factor of 890654 is ");
      System.out.println(maxPrimeFactors(userInput));
   }

   static long maxPrimeFactors(long detectInput) {
      long max_prime = -1; // Initialize max_prime with the lowest value.

      while (detectInput % 2 == 0) { // If detectInput modulus(%) 2 has no remainder, the maximum prime no. is 2.
         max_prime = 2;
         detectInput >>= 1; // equivalent to n /= 2 (MORE TO LEARN...)
      }

      // detectInput must be odd after removing all factor 2 in the detectInput. Thus,
      // the even number are skipped.
      // Only odd integer would be iterated now.
      for (int i = 3; i <= Math.sqrt(detectInput); i += 2) {
         // Extracting all possible 9dd factors from the smallest to the biggest until
         // the square root of detectInput (WHY??).
         while (detectInput % i == 0) {
            // If the detectInput can be divided by the current odd factor, try the current
            // odd factor again.
            max_prime = i;
            detectInput = detectInput / i;
         }
      }

      // Case: detectInput is a prime number greater than 2.
      if (detectInput > 2) // The remain value after all extraction (from smallest to biggest).
         max_prime = detectInput;

      return max_prime;
   }

}
