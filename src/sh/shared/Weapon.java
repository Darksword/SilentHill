package sh.shared;

import java.io.Serializable;

import sh.shared.Audio; 

public class Weapon implements Serializable{
	
	private String name;
	private int meleeAtk;
	private int atk; // attack using ammo
	private int dur; //durability
	private boolean isMelee = false; 
	private int ammo;
	private String audioFile;
	
	// Melee Wpn Constructor
	public Weapon (String wName, int wMeleeAtk, int wDur, String wAudioFile) {
		name = wName;
		meleeAtk = wMeleeAtk;
		dur = wDur;
		audioFile = wAudioFile;
		isMelee = true; 
	}
	
	// Firearms Wpn Constructor
	public Weapon (String wName, int wMeleeAtk, int wAtk, int wDur, int wAmmo, String wAudioFile) {
		name = wName;
		meleeAtk = wMeleeAtk;
		atk = wAtk; 
		dur = wDur;
		ammo = wAmmo;
		audioFile = wAudioFile;
	}
	
	public String getName(){
		return name; 
	}
	
	public int getMAtk(){
		return meleeAtk;
	}
	
	public int getAtk(){
		return atk;
	}
	
	public int getDur(){
		return dur;
	}
	
	public int getAmmo(){
		if (isMelee){
			return 0;
		} else {
			return ammo;
		}
	}
	
	public String getType(){
		if (isMelee) {
			return "melee";
		} else {
			return "firearm";
		}
	}
	
	public String getAudio(){
		return audioFile;
	}
	
	public void shoot() {
		if (ammo > 0){
			ammo--;
		} else {
			System.out.println("No more ammo remaining.");
		}
	}
	
	public void playEffect(String wAudioFile) 
	{
		String filename = wAudioFile;
		Audio mp3 = new Audio(filename);
		mp3 = new Audio(filename);
		mp3.play();	
	}
}
