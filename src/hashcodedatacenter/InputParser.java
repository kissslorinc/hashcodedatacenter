package hashcodedatacenter;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputParser {
	private enum ReadState {INITREAD,INACTIVEREAD,SERVERREAD};
	ReadState readState=ReadState.INITREAD;
	
	public void read(String path) {
		try {
			FileReader fr=new FileReader("testinput.txt");
			BufferedReader br=new BufferedReader(fr);
			String[] instr;
			int maxUnavailable;
			int maxPools;
			while (br.ready()) {
				instr=br.readLine().split(" ");
				switch (readState)  {
				case INITREAD:
					DataCenter.initializeRows(Integer.parseInt(instr[0]), Integer.parseInt(instr[1]));
					break;
				case INACTIVEREAD:
					break;
				case SERVERREAD:
					break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
