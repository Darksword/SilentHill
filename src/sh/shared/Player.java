package sh.shared;


public class Player extends Entity
{	
	
	public Player(String pName, int hitPoints, int atkPoints, Room pRoom, Weapon wpn )
	{
		super(pName, hitPoints, atkPoints, pRoom, wpn);
	}
	
	public String getHealthStatus(){
		// Each entity has some variation of this
		
		if (getHp() < 0){
			return "You are dead.";
	    } else if (getHp() < getDyingThreshold()){
			return "You are dying.";
		} else if (getHp() < getNearDeadThreshold()) {
			return "You are near dead.";
		} else if (getHp() < getHeavilyInjuredThreshold()) {
			return "You are heavily injured";
		} else if (getHp() < getSomewhatInjuredThreshold()) {
			return "You are somewhat injured.";
		} else if (getHp() < getInjuredThreshold()) {
			return "You are injured.";
		} else {
			return "You are in good condition.";
		}
	}
	
}
