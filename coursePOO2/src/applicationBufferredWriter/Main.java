package applicationBufferredWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		String[] line = new String[] {"Good Moring", "Good afternoon","Reinaldo Pires","po"};
		
		String path = "C:\\projeto_JAVA\\zPrint\\01_Codigos\\02out.txt";
		
		try (BufferedWriter bw  = new BufferedWriter(new FileWriter(path, true))){
			for(String l : line) {
				bw.write(l);
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
