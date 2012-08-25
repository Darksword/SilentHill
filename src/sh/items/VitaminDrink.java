package sh.items;

import sh.shared.Entity;
import sh.shared.Items;

public class VitaminDrink extends Items {

	public VitaminDrink () {
		super("Vitamin Drink", true);
	}
	
	public void onUse (Entity entity) {
		entity.restoreHP(8);
	}
}
