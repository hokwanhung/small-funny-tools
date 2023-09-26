import java.util.Scanner;

public class HtmlConverter_v0 {

	// Append <li> elements in front and at the end of every input
	public String toList(String input) {
		String output = "<li>" + input.trim() + "</li>";
		return output;
	}
	
	// Append <br> element in front of the input
	public String toNextLine(String input) {
		String output = "<br>" + input.trim();
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlConverter_v0 hcv0 = new HtmlConverter_v0();
		Scanner s = new Scanner(System.in);
		
		String cmd = "intoList";
		boolean isExit = false;

		while (!isExit) {
			System.out.print("Enter input/command: ");
			String input = s.nextLine();
			
			switch (input.toLowerCase()) {
			case "tolist":
				cmd = "toList";
				System.out.println("Command changed!");
				break;
			case "tonextline":
				cmd = "toNextLine";
				System.out.println("Command changed!");
				break;
			case "exit":
				isExit = true;
				break;
			default:
				String output = "";
				// Use String variable cmd to store which method to use.
				switch (cmd) {
				case "toList":
					output = hcv0.toList(input);
					break;
				case "toNextLine":
					output = hcv0.toNextLine(input);
					break;
				}
				System.out.println("Output: ");
				System.out.println(output);
				break;
			}
		}

	}

}
