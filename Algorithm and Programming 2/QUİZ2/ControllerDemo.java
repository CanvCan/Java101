package srcPackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ControllerDemo {
	
	public static void main(String[] args) throws IOException {
			
			File file = new File("C:\\Users\\Can\\Desktop\\Numbers.txt");
			NumberController numberController = new NumberController(file);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Lütfen listede aramak istediğiniz sayıyı giriniz (Binary Search): ");
			int a = input.nextInt();
			System.out.println(numberController.searchBinary(a));
			
			System.out.println("Lütfen listede aramak istediğiniz sayıyı giriniz (Sequential Search): ");
			int b = input.nextInt();
			System.out.println(numberController.searchSequential(b));
			input.close();
	
		}

}
