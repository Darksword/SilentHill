package sh.entity.monsters;

import sh.shared.Monster;
import sh.shared.Room;

public class Bleeder extends Monster{

	public Bleeder(String pName, int hitPoints, int atkPoints, Room pRoom) {
		super(pName, hitPoints, atkPoints, pRoom);
	}
	
	public String getHealthStatus(){
		// Each entity has some variation of this
		if (getHp() < 0){
			return "The bleeder is dead.";
	    } else if (getHp() < getDyingThreshold()){
			return "The bleeder is dying.";
		} else if (getHp() < getNearDeadThreshold()) {
			return "The bleeder is near dead.";
		} else if (getHp() < getHeavilyInjuredThreshold()) {
			return "heavily injured";
		} else if (getHp() < getSomewhatInjuredThreshold()) {
			return "The bleeder is somewhat injured.";
		} else if (getHp() < getInjuredThreshold()) {
			return "The bleeder is injured.";
		} else {
			return "The bleeder is in good condition.";
		}
	}
}
