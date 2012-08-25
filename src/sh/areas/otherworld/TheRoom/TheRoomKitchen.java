package sh.areas.otherworld.TheRoom;

import java.util.Scanner;

import sh.items.Room208Key;
import sh.items.VitaminDrink;
import sh.shared.Player;
import sh.shared.Room;

public class TheRoomKitchen extends Room {
	
	// Has player taken these items?
	private boolean isVDrink1Here;
	private boolean isVDrink2Here;
	
	public TheRoomKitchen()
	{
		super(null, null, null, null, true);
		isVDrink1Here = true;
		isVDrink2Here = true;
	}
	
	public void onEnter()
	{
		// Description
		System.out.println("\nNext to you is the hallway leading to the bathroom and bedroom.");
		System.out.println("In your kithcen you see a [[rusted fridge]].");
		System.out.println("The sink is dripping red colored water...could it be blood?");
		System.out.println("On the [[counter]] is something that looks like a juice bottle\n");
		
		// Player Input
		System.out.println("Rooms:");
		System.out.println("L: Leave the Apartment");
		System.out.println("W: Go into the hallway");
		System.out.print("\n> ");	
		
	}
	public void examinables(Player player, String input) {	
		if (input.toLowerCase().contains("rusted") || input.toLowerCase().contains("fridge")) {
			System.out.print("You open the fridge and see molded food. The stench of rotted waste fills in the air. ");
			
			if (isVDrink1Here) {
				System.out.println("There looks to be a new [[cold drink]] though.\n");
				System.out.println("L: Walk Away");
				System.out.print("\n> ");	
				
				// Code for Vitamin Drink - Fridge
				@SuppressWarnings("resource")
				Scanner vitaminFridge = new Scanner(System.in);
				String pInput = vitaminFridge.nextLine();
				
				// Code to either pick up the drink or walk away
				if (pInput.toLowerCase().contains("cold") || pInput.toLowerCase().contains("drink")) {
					if (isVDrink1Here){
						System.out.println("The cold drink appears to be a Vitamin Drink.");
						System.out.println("T: Take");
						System.out.println("L: Walk Away");
						System.out.print("\n> ");	
						
						vitaminFridge = new Scanner(System.in);
						pInput = vitaminFridge.nextLine();
						
						// Add drink to inventory or walk away
						if (pInput.toLowerCase().equals("t"))
						{
							// Add item to inventory
							System.out.println("Vitamin Drink (x1) added!");
							player.addToInventory(new VitaminDrink());
							isVDrink1Here = false;
							System.out.print("\n> ");
						}
						if (pInput.toLowerCase().equals("l"))
						{
							System.out.print("\n> ");	// Simply jumps back
						}
					} else {
						System.out.println("You've already taken the drink.");
					}
			    }
			} 
		}
		else if (input.toLowerCase().contains("counter")) {
				
			if (isVDrink2Here) {
					
				System.out.println("You find a Vitamin Drink on the counter.");
				System.out.println("T: Take");
				System.out.println("L: Leave");
				System.out.print("\n> ");	
					
				@SuppressWarnings("resource")
				Scanner vitaminFridge = new Scanner(System.in);
				String pInput = vitaminFridge.nextLine();
				if (pInput.toLowerCase().equals("t")) {
					// Add item to inventory
					System.out.println("Vitamin Drink (x1) added!\n");
					player.addToInventory(new VitaminDrink());
					isVDrink2Here = false;
					System.out.print("> ");
				}
				if (pInput.toLowerCase().equals("l")) {
						System.out.print("\n> ");	// Simply jumps back
				}
			} else {
					System.out.println("There's nothing on the counter.");
			}
			
		}
		else if (input.toLowerCase().equals("l")){
				System.out.println("The door is locked...from the inside. How is this possible?");
				System.out.print("\n> ");
				player.useFromInventory("key");    /////////////////////////////////////////////////////////////////////////
		}
		else {
				System.out.println("Nothing out of the ordinary.\n");
		}
	}
}
