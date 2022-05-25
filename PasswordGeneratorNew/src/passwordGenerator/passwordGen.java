package passwordGenerator;

import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;

public class passwordGen{
	
	private static int oldRandom = -1;

	public static void main(String[] args) {
		
		System.out.println("How long do you want your password to be? (Insert numbers only (0-9))");
		Scanner input = new Scanner(System.in);
		
		int length = input.nextInt();
		
		String lowerCase = "qwertyuiopasdfghjklzxcvbnm";
		String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String specialChar = "!@#$%^&*()-_=+`~[]{}|;:,<>.?";
		
		String password = "";
		
		for(int i = 0; i < length; i++) {
			int random = (int)(4 * Math.random());
			System.out.println("We are on character index: " + i);
			System.out.println("random is: " + random);
			System.out.println("oldRandom is: " + oldRandom);
			if(random != oldRandom) {
				switch(random) {
					case 0:
						password += String.valueOf((int)(10 * Math.random()));
						oldRandom = random;
						break;
					case 1:
						oldRandom = random;
						random = (int)(lowerCase.length() * Math.random());
						password += String.valueOf(lowerCase.charAt(random));
						break;
					case 2:
						oldRandom = random;
						random = (int)(upperCase.length() * Math.random());
						password += String.valueOf(upperCase.charAt(random));
						break;
					case 3:
						oldRandom = random;
						random = (int)(specialChar.length() * Math.random());
						password += String.valueOf(specialChar.charAt(random));
						break;
				}
			} else {
				oldRandom = random;
				i--;
			}
		}
		System.out.println("Your generated password is: " + password);
		StringSelection copiedPassword = new StringSelection(password);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		ClipboardOwner owner = null;
		clipboard.setContents(copiedPassword, owner);
	}
}
