package hashcodedatacenter;

import java.util.ArrayList;
import java.util.Comparator;



public class DataCenter {
	private static int poolLastId=0;
	private static int serverLastId=0;
	public static ArrayList<Server> servers  = new ArrayList<>(); 
	public static ArrayList<Row> rows = new ArrayList<>();
	public static ArrayList<Pool> pools = new ArrayList<>();
	
	public static void main(String[] args) {
		InputParser.read("testinput.txt");
		ArrayList<Server> orderedServer = new ArrayList<>();
		orderedServer.addAll(servers);
		orderedServer.sort(new Comparator<Server>(){
			@Override
			public int compare(Server o1, Server o2) {
				return Double.compare(o1.utility, o2.utility);	
			}
		});
		
		
		
	int dir = 1;
	int i = -1;
	int j = 0;
	boolean changed = false; 
	do{
		changed = false;
		i+=dir;
		if(i < 0 || i >= pools.size()){
			dir *= -1;
			i+=dir;
		}
		
		Server s = servers.remove(0);
		for(int k = j; k-j <= rows.size(); k++){
			if(rows.get(k%rows.size()).isFit(s)){
				rows.get(k%rows.size()).putServer(s);
				pools.get(i).addServer(s);
				s.pool= pools.get(i);
				s.row = rows.get(k%rows.size());
				changed = true;
				break;
			}
		}
	}
	while(changed);
	for (int k = 0; k < rows.size(); k++) {
		for (int l = 0; l < rows.get(k).slots.size(); l++) {
			if (rows.get(k).slots.get(l).containedServer != null)
			System.out.print(rows.get(k).slots.get(l).containedServer.size + " ");
			else
				System.out.print("x ");
		}
		System.out.println();
	}
	
	int score=-1;
	for (int inactiveRowIndex=0;inactiveRowIndex<DataCenter.rows.size();inactiveRowIndex++) {
		for (Pool p : DataCenter.pools) {
			int poolSum=0;
			for (Server s : p.servers) {
				if (!s.row.equals(DataCenter.rows.get(inactiveRowIndex))) poolSum+=s.capacity;
			}
			if (score<0 || poolSum<score) score=poolSum;
		}
	}				
	System.out.println(score);
	
	}
	
	
	
	
	public static void initializeRows(int _numberOfRows, int _numberOfSlots) {
		rows = new ArrayList<Row>();
		for (int i = 0; i < _numberOfRows; i++) {
			rows.add(new Row(_numberOfSlots));
		} 
		System.out.println("Initialized Data Center with "+_numberOfRows + " rows and "+_numberOfSlots+ " slot in each row.");
	};
	public static void disableSlot(int _row, int _column) {
		rows.get(_row).disableSlot(_column);
		System.out.println("Disabled slot in row "+_row+" and column "+_column);
	};
	public static void addServer(int _size, int _capacity) {
		servers.add(new Server(serverLastId++, _size, _capacity));
	};
	public static void initializePools(int _numberOfPools) {
		for (int i = 0; i < _numberOfPools; i++) {
			pools.add(new Pool(poolLastId++));
		}
	}

}
