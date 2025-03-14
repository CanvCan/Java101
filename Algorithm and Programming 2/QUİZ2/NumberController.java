package srcPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NumberController {
	
	public int[] arrayList = new int[20];
	
	public NumberController(File file) throws IOException {
		 
		 BufferedReader bReader = new BufferedReader(new FileReader(file));
         String lineText;
         
         for(int i = 0; i < arrayList.length; i++) {
        	 
        	 lineText = bReader.readLine();
             int lineTextInt = Integer.parseInt(lineText);
           	 arrayList[i] = lineTextInt;
           	 
         }
         
         bReader.close();  
         
         bubbleSort(arrayList);
         
	}
	
	
	public static void bubbleSort(int[] arrayList) {
		
		for (int i = 0; i < arrayList.length - 1; i++) {
			
			for (int j = 0; j < arrayList.length - 1 - i; j++) {
				
				if (arrayList[j] > arrayList[j + 1]) {
					
					int temp = arrayList[j];
					arrayList[j] = arrayList[j + 1];
					arrayList[j + 1] = temp;
					
				}
			}
			
		}
		
	}
	
	
	public boolean searchBinary(int target) {
		
		int i = 0;
		int j = arrayList.length - 1;
		boolean isThere  = false;
		
		while (i < j) {
			
			int m = (i + j) / 2;
			if(target > arrayList[m]) {
				
				i = m + 1;
						
			} else {j = m;}
			
			if (target == arrayList[i]) {
				
				isThere = true;
				
			}
		}
		
		return isThere;
		
	}
	
	
	public boolean searchSequential(int target) {
			
			boolean isThere  = false;
			int i = 0;
			while (i < arrayList.length && target != arrayList[i]) {
				
				i++;
				
			}
			
			if (i < arrayList.length) {
				
				isThere = true;
				
			}
			
			return isThere;
				
		}
		

}
