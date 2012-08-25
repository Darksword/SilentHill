package sh.shared;

import java.io.Serializable;

import sh.entity.interactive.Door;

public class Items implements Serializable {

	private String name;
	private boolean useableAnytime;
	
	public Items (String iName, boolean usability) {
		name = iName;
		useableAnytime = usability;
	}
	
	public void onUse (Entity entity) {

	}
	
	public String getName() {
		return name;
	}

	public boolean isUseableAnytime() {
		return useableAnytime;
	}
	
}
