package hashcodedatacenter;

public class DataCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void initializeRows(int _numberOfRows, int _numberOfSlots) {
		System.out.println("Initialized Data Center with "+_numberOfRows + " rows and "+_numberOfSlots+ " slot in each row.");
	};
	public static void disableSlot(int _row, int _column) {
		System.out.println("Disabled slot in row "+_row+" and column "+_column);
	};
	public static void addServer(int _size, int _capacity) {
		System.out.println("Added server with a size of "+ _size+" and capacity of "+_capacity);
	};
	public static void initializePools(int _numberOfPools) {
		
	}

}
