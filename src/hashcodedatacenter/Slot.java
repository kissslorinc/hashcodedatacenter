package hashcodedatacenter;

public class Slot {
	public Server containedServer=null;
	public boolean enabled=true;
	
	public boolean isAvailable(){
		return enabled && containedServer==null;
	}
}
