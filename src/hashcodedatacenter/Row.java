package hashcodedatacenter;

import java.util.ArrayList;

public class Row {
	
	ArrayList<Slot> slots = new ArrayList<Slot>();

	public Row(int _numberOfSlots) {
		for (int i = 0; i < _numberOfSlots; i++) {
			slots.add(new Slot());	
		}
	}
	
	void disableSlot(int _index) {
		slots.get(_index).enabled=false;
	}
	
	public boolean isFit(Server _s){
		for (int i = 0; i < slots.size(); i++) {
			if(slots.get(i).isAvailable()){
				for (int j = 1; i+j < slots.size() && !slots.get(i + j).isAvailable() ; j++) {
					if(j >= _s.size){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void putServer(Server _s){
		for (int i = 0; i < slots.size(); i++) {
			if(slots.get(i).isAvailable()){
				for (int j = 1; i+j < slots.size() && !slots.get(i + j).isAvailable() ; j++) {
					if(j >= _s.size){
						for (int j2 = i; j2 < _s.size; j2++) {
							slots.get(j2).containedServer = _s;
						}
					}
				}
			}
		}
	}

}
