package sh.items;

import sh.entity.interactive.Door;
import sh.shared.Entity;
import sh.shared.Items;

public class Room208Key extends Items {

	public Room208Key() {
		super("key", false);
	}
	
	public void onUseDoor (Entity entity) {
		if (entity instanceof Door  && entity.getName().equals("key")){
			((Door) entity).setLocked(false);
		} else {
			System.out.println("That won't work.");
		}
	}
	
}