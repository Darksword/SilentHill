package sh.entity.interactive;

import sh.shared.Entity;
import sh.shared.Room;
import sh.shared.Weapon;

public class Door extends Entity {
	
	private boolean isLocked;
	
	public Door(String pName, int hitPoints, int atkPoints, Room pRoom, Weapon wpn) {
		super(pName, hitPoints, atkPoints, pRoom, wpn);
		isLocked = false;
	}
	
	public boolean isLocked(){
		return isLocked;
	}
	
	public void setLocked (boolean b){
		isLocked = b;
	}

}
