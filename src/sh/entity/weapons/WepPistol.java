package sh.entity.weapons;

import sh.shared.Weapon;

public class WepPistol extends Weapon {

	public WepPistol(int wMeleeAtk, int wAtk, int wDur, int wAmmo) {
		super("Pistol", wMeleeAtk, wAtk, wDur, wAmmo, "SoundEffects/PistolFire.mp3");
	}
	
}
