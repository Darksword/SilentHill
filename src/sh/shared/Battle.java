package sh.shared;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Battle {

	public Battle (Player player, ArrayList<Monster> monsters, String musicFile){
		//initiate battle music		
		String battleMusic = musicFile;
		Audio bM = new Audio(battleMusic);
		bM = new Audio(battleMusic);
		bM.play();

		// Print encounter details to player
		for(Monster monster : monsters) {
			System.out.println("|-------  Encounter: " + monster.getName() + "  -------|");
			//System.out.println("Encounter: " + monster.getName());
		}
		
		Entity current; // The Entity whose turn it is
		Random dice = new Random();
		
		System.out.println("\nChoose wisely..."); 	
		System.out.println("M: Melee"); 	
		System.out.println("S: Shoot"); 	
		System.out.println("D: Defend"); 
		System.out.println("H: Check Health");
		System.out.println("EH: Check Enemy Health");
		System.out.println("E: Escape\n"); 			
			
		
		// Battle loop
		while(true){
			int num = dice.nextInt(4); // Random Dice Roller 4 is the highest number that can be rolled.
			if (num < 3) { // Player goes if the number is less than four (75% in favor of player)
				current = player;
			} else {
				int index = dice.nextInt(monsters.size());
				current = monsters.get(index);
			}
			
			if (current != player){
				System.out.println(current.getName() + " damages you!");
				current.meleeAttack(player);
				if (player.isDead()){
					System.out.println("Now you're nothing more than the ashes of history...");
					System.exit(0);
				}
			} else {
				
				System.out.print("> ");
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				String pInput = input.nextLine();
				
				// Pick random monster to attack
				int index = dice.nextInt(monsters.size());
				Monster toAttack = monsters.get(index);
				
				// Melee 
				if (pInput.toLowerCase().equals("m")){
					player.meleeAttack(toAttack);
					System.out.println("You bash " + toAttack.getName());
					if (toAttack.isDead()){
						System.out.println(toAttack.getName() + " has died.");
						monsters.remove(index);
					}
					if (monsters.size() == 0){
						System.out.println("\n|-------  All monsters have been killed -------|");
						bM.close();
						break;
					}
				} 
				// Shoot
				else if (pInput.toLowerCase().equals("s")){
					//System.out.println("You have this much ammo: " + player.getWpn().getAmmo());
					if (player.getWpn() != null){
						if (player.getWpn().getType().equals("firearm")){
							if (player.getWpn().getAmmo() > 0){
								player.attack(toAttack);
								player.getWpn().shoot();
								player.getWpn().playEffect(player.getWpn().getAudio());
								System.out.println("You shoot " + toAttack.getName() + " with your " + player.getWpn().getName());
							} else {
								System.out.println("No more ammo remaining in " + player.getWpn().getName());
							}
						} else {
							System.out.println("You cannot shoot with a " + player.getWpn().getName());
						}
					} else {
						System.out.println("You have no weapon to shoot with...");
					}
					if (toAttack.isDead()){
						System.out.println(toAttack.getName() + " has died.");
						monsters.remove(index);
					}
					if (monsters.size() == 0){
						System.out.println("\n|-------  All monsters have been killed -------|");
						bM.close();
						break;
					}
				} 
				// Defend
				else if (pInput.toLowerCase().equals("d")){
					// put code here
				}
				// Check Health
				else if (pInput.toLowerCase().equals("h")){
					System.out.println(player.getHealthStatus());
				}
				// Check Enemy Health
				else if (pInput.toLowerCase().equals("eh")){
					for (Monster monster : monsters){
						System.out.println(monster.getHealthStatus());
					}
				}
				// Escape
				else if (pInput.toLowerCase().equals("e")){
					if (player.getRoom().hasExits()){
						// Escape code
					} else {
						System.out.println("There's nowhere to run!");
					}
				}
			}
		}
	}
}
