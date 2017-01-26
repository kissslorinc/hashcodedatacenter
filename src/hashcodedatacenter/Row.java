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

}
