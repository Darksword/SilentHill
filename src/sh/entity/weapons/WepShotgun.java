package sh.entity.weapons;

import sh.shared.Weapon;

public class WepShotgun extends Weapon {

	public WepShotgun(int wMeleeAtk, int wAtk, int wDur, int wAmmo) {
		super("Shotgun", wMeleeAtk, wAtk, wDur, wAmmo, "SoundEffects/GUNFIRE_SHOTGUN.mp3");
	}
	
}