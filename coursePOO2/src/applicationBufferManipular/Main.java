package applicationBufferManipular;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folder");
		for(File folder : folders) {
			System.out.println(folder);
		}
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files");
		for(File f : files) {
			System.err.println(f);
		}
		
		boolean sucess = new File(strPath + "\\test").mkdir();
		System.out.println("Directory created successfuly " + sucess);
 		
		sc.close();
	}
}
