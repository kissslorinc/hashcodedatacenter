package hashcodedatacenter;

import java.util.ArrayList;
import java.util.Comparator;

public class DataCenter {

	private static int serverLastId=0;
	public static ArrayList<Server> servers; 
	public static void main(String[] args) {
		
		ArrayList<Server> orderedServer = (ArrayList<Server>) servers.clone();
		orderedServer.sort(new Comparator<Server>(){
			@Override
			public int compare(Server o1, Server o2) {
				return Double.compare(o1.utility, o2.utility);	
			}
		});
		for (int i = 0; i < args.length; i++) {
			
		}
	}
	
	public static void initializeRows(int _numberOfRows, int _numberOfSlots) {
		System.out.println("Initialized Data Center with "+_numberOfRows + " rows and "+_numberOfSlots+ " slot in each row.");
	};
	public static void disableSlot(int _row, int _column) {
		System.out.println("Disabled slot in row "+_row+" and column "+_column);
	};
	public static void addServer(int _size, int _capacity) {
		servers.add(new Server(serverLastId++, _size, _capacity));
	};
	public static void initializePools(int _numberOfPools) {
		
	}

}
