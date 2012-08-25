package sh.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Entity implements Serializable {
	
		private String pname;
		private int hp;
		private int maxHp;
		private int atk; // Base Attack
		private Room room; 
		private Weapon weapon;
		
		private ArrayList<Items> inventory = new ArrayList<Items>();

		private int dyingThreshold;
		private int nearDeadThreshold;
		private int heavilyInjuredThreshold;
		private int somewhatInjuredThreshold;
		private int injuredThreshold;
		
		public Entity (String pName, int hitPoints, int atkPoints, Room pRoom, Weapon wpn)
		{
			
			pname = pName; 
			hp = hitPoints; 
			atk = atkPoints; 
			room = pRoom; 
			weapon = wpn;
			
			maxHp = hp;
			
			dyingThreshold = (int) (hp * 0.1);
			nearDeadThreshold = (int) (hp * 0.1);
			heavilyInjuredThreshold = (int) (hp * 0.4);
			somewhatInjuredThreshold = (int) (hp * 0.6);
			injuredThreshold = (int) (hp * 0.8);
		}
		

		public void addToInventory(Items item){
			inventory.add(item);
		}
		
		private void removeFromInventory(Items item){
			inventory.remove(item);
		}
		
		public void checkInventory(){
			System.out.println("You have: ");
			for (Items item : inventory){
				System.out.println(item.getName());
			}
			if (weapon != null) {
				System.out.println(weapon.getName());
			}
		}
		
		public boolean doesInventoryContain (String name) {
			for (Items item : inventory){
				if (item.getName().toLowerCase().equals(name)) {
					return true;
				}
			}
			return false;
		}
		
		public void useFromInventory(String name){
			if (doesInventoryContain(name)){
				for (Items item : inventory){
					if (item.getName().toLowerCase().equals(name)) {
						if (item.isUseableAnytime()){
							item.onUse(this);
							removeFromInventory(item);
							break;
						} else {
							System.out.println("You cannot use that here.");
						}
					}
				}
			} else if (weapon.getName().toLowerCase().equals(name)) {
				System.out.println("You can't use a weapon outside of combat.");
			} else {
				System.out.println("You don't have that in your inventory.");
			}
		}
	
		public ArrayList<Items> getInventory(){
			return inventory;
		}
		
		public void setInventory (ArrayList<Items> invent){
			inventory = invent;
		}
		
		
		
		public String getName()
		{
			return pname;
		}
		
		public int getHp()
		{
			return hp;
		}
		
		public void restoreHP (int amount) {
			hp += amount;
			if (hp > maxHp){
				hp = maxHp;
			}
		}
		
		public int getMaxHp() {
			return maxHp;
		}

		public int getDyingThreshold () {
			return dyingThreshold;
		}
		
		public int getNearDeadThreshold () {
			return nearDeadThreshold;
		}
		
		public int getHeavilyInjuredThreshold () {
			return heavilyInjuredThreshold;
		}
		
		public int getSomewhatInjuredThreshold () {
			return somewhatInjuredThreshold;
		}
		
		public int getInjuredThreshold () {
			return injuredThreshold;
		}
		
		public String getHealthStatus(){
			// Each entity has some variation of this
			if (getHp() < 0){
				return "dead";
		    } else if (getHp() < getDyingThreshold()){
				return "dying";
			} else if (getHp() < getNearDeadThreshold()) {
				return "near dead";
			} else if (getHp() < getHeavilyInjuredThreshold()) {
				return "heavily injured";
			} else if (getHp() < getSomewhatInjuredThreshold()) {
				return "somewhat injured";
			} else if (getHp() < getInjuredThreshold()) {
				return "injured";
			} else {
				return "good";
			}
		}

		
		// Melee Atk
		public int getMAtk(){ 
			if (weapon != null) {
				return atk + weapon.getMAtk();
			} else {
				return atk;
			}
		}
		
		// Firearm attack
		public int getFAtk(){ 
			if (weapon != null) {
				return atk + weapon.getAtk();
			} else {
				return atk;
			}
		}
		
		public Room getRoom()
		{
			return room;
		}
	
		public void goToRoom(Room newRoom)
		{
			if (newRoom != null) {
				room = newRoom;
				room.onEnter();
			} else {
				System.out.println("There's nothing to see.");
			}
		}
		
		public Weapon getWpn(){
			return weapon;
		}
		
		public void setWpn(Weapon wpn)
		{
			weapon = wpn;
		}
		
		
		///// Combat methods /////
		
		public void meleeAttack(Entity other){
			other.onAttacked(getMAtk());
		}
		
		public void attack(Entity other){
			other.onAttacked(getFAtk());
		}
		
		public int onAttacked(int damage) {
			hp = hp - damage;
			return hp;
		}
		
		public boolean isDead(){
			if (hp > 0){
				return false;
			} else {
				return true;
			}
		}
}