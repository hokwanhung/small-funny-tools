/* Method used to detect input type and continuously requesting users until the correct type is given.
   This is originally a part of a sellingMachine class so a detection of String "STOP" is included to exit the execution.
   The function returns a String instead of actual values so as to fits with the detection of String "STOP".
   The conversion of String to integer, as well as the stop of execution, relies on the main method (and the if-else statement inside).
   The input of the method detectInput(String detectTarget) also request the user's input to be in a string form, though the user never knows.
   */
   
   
public static String detectInput (String detectTarget) { 
		boolean detectInputTag = true;
		double temporaryIntegerValueStorageDouble;
		int temporaryIntegerValueStorageInteger;
		int detectIntegerValueProperty;
		
		Scanner keyboardInputNew = new Scanner(System.in);
		
		while (detectInputTag) {
			try {
				if (detectTarget.equals("STOP")) { // Detect string input of "STOP".
					System.out.println("You have requested to stop the machine. Machine shutting down...");
					detectInputTag = false; // Exit the while loop.
				} else {
					temporaryIntegerValueStorageDouble = Double.parseDouble(detectTarget); 
                                          // Used as a detection of other string inputs instead of "STOP".
					if ((temporaryIntegerValueStorageDouble == Math.floor(temporaryIntegerValueStorageDouble) && !Double.isInfinite(temporaryIntegerValueStorageDouble))) {
						// Detect whether the number is a double or an integer.
						temporaryIntegerValueStorageInteger = (int) temporaryIntegerValueStorageDouble; 
                                                // Turning the double (but actually integer) into a 'official' integer.
						detectIntegerValueProperty = Integer.signum(temporaryIntegerValueStorageInteger); 
                                                // Detect whether the input is positive, zero or negative.
						if (detectIntegerValueProperty == 1) { // If the input is possitive, returns.
							System.out.println("You have inserted a positive integer. Machine calculating..."); 
							detectInputTag = false;
						} else { // If the integer is 0 or has a negative value, the user have to insert again.
							System.out.println("You have inserted a zero or a negative integer. Please insert either a positive integer or 'STOP'.");
							detectTarget = keyboardInputNew.next();
						}
					}	else { // If the input is not a integer, the user have to insert again.
						System.out.println("Invalid input. Please insert either a positive integer or 'STOP'.");
						detectTarget = keyboardInputNew.next();
					}
				}
			} catch (NumberFormatException e) { // If the input is neither a "STOP" or a double(an integer), the user have to insert again.
				System.out.println("Invalid input. Please insert either a positive integer or 'STOP'.");
				detectTarget = keyboardInputNew.next();
			} 
		} 
		return detectTarget;
	} 
