package hashcodedatacenter;

public class Server {
	int id;
	int size;
	int capacity;
	double utility;
	Row row;
	Pool server;
	
	Server(int _id, int _size, int _capacity){
		id = _id;
		size = _size;
		capacity = _capacity;
		utility = capacity/size;
	}
}
