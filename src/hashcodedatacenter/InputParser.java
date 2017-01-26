package hashcodedatacenter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class InputParser {
	void read(String path) {
		try {
			FileReader fr=new FileReader("testinput.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
