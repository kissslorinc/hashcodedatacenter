package hashcodedatacenter;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputParser {
	private enum ReadState {INITREAD,INACTIVEREAD,SERVERREAD};
	
	public static void read(String path) {
		ReadState readState=ReadState.INITREAD;
		try {
			FileReader fr=new FileReader(path);
			BufferedReader br=new BufferedReader(fr);
			String[] instr;
			int maxUnavailable=-1;
			int numOfServers=-1;
			while (br.ready()) {
				instr=br.readLine().split(" ");
				switch (readState)  {
				case INITREAD:
					DataCenter.initializeRows(Integer.parseInt(instr[0]), Integer.parseInt(instr[1]));
					maxUnavailable=Integer.parseInt(instr[2]);
					DataCenter.initializePools(Integer.parseInt(instr[3]));
					numOfServers=Integer.parseInt(instr[4]);
					 readState=ReadState.INACTIVEREAD;
					break;
				case INACTIVEREAD:
					DataCenter.disableSlot(Integer.parseInt(instr[0]), Integer.parseInt(instr[1]));
					maxUnavailable--;
					if (maxUnavailable==0)
						readState=ReadState.SERVERREAD;
					break;
				case SERVERREAD:
					DataCenter.addServer(Integer.parseInt(instr[0]), Integer.parseInt(instr[1]));
					break;
				}
			}
			br.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
