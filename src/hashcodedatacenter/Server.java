package hashcodedatacenter;

public class Server {
	int id;
	int size = 0;
	int capacity = 0;
	double utility;
	Row row;
	Pool pool;
	
	Server(int _id, int _size, int _capacity){
		id = _id;
		size = _size;
		capacity = _capacity;
		utility = (double)capacity/size;
	}
}
