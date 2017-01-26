package hashcodedatacenter;

import java.util.ArrayList;

public class Row {
	public Row(int _numberOfSlots) {
		for (int i = 0; i < _numberOfSlots; i++) {
			slots.add(new Slot());	
		}
	}

	ArrayList<Slot> slots = new ArrayList<Slot>();
}
