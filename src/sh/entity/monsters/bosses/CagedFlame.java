package sh.entity.monsters.bosses;

import sh.shared.Monster;
import sh.shared.Room;

public class CagedFlame extends Monster{

	public CagedFlame(String pName, int hitPoints, int atkPoints, Room pRoom) {
		super(pName, hitPoints, atkPoints, pRoom);
	}
	
	public String getHealthStatus(){
		// Each entity has some variation of this
		if (getHp() < 0){
			return "Dead";
	    } else if (getHp() < getDyingThreshold()){
			return "Dying";
		} else if (getHp() < getNearDeadThreshold()) {
			return "Near Death";
		} else if (getHp() < getHeavilyInjuredThreshold()) {
			return "Heavily Injured";
		} else if (getHp() < getSomewhatInjuredThreshold()) {
			return "Somewhat Injured";
		} else if (getHp() < getInjuredThreshold()) {
			return "Injured";
		} else {
			return "Perfect Health";
		}
	}
	

}
