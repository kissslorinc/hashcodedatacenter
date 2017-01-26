package hashcodedatacenter;

import java.util.HashSet;

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
