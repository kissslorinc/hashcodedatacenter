package hashcodedatacenter;

import java.util.HashSet;
import java.util.Iterator;

public class Pool {
	int id;
	HashSet<Server> servers;
	Pool(int id){
		servers = new HashSet<Server>();
	}
	
	public void addServer(Server _server){
		servers.add(_server);
	}

	
	
	
}
