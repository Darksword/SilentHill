package sh.areas.otherworld.TheRoom;

import java.util.ArrayList;
import java.util.Scanner;

import sh.entity.monsters.Teardrop;
import sh.entity.weapons.WepPistol;
import sh.items.PistolAmmo;
import sh.items.Room208Key;
import sh.shared.Battle;
import sh.shared.Monster;
import sh.shared.Player;
import sh.shared.Room;

public class TheRoomBathroom extends Room{

	public TheRoomBathroom() {
		super(null, null, null, null, true);
		
			
		
	}
	public void onEnter()
	{
		// Description
		System.out.println("Theres nothing left of the bathroom, except a [[rusted tub]]. The rest has fallen into a dark abyss.\n");
		
		// Player Input
		System.out.println("Rooms:");
		System.out.println("S: Hallway");
		System.out.print("\n> ");
	}
	@SuppressWarnings("resource")
	public void examinables(Player player, String input) 
	{
		if (input.toLowerCase().contains("tub"))
		{
			System.out.println("The tub is full of filthfy black and green water. You see some sort of object, will you grab it?");
			System.out.println("Y: Yes");
			System.out.println("N: No");
			System.out.print("\n> ");
			
			Scanner rustedTub = new Scanner(System.in);
			String pInput = rustedTub.nextLine();

			if (pInput.toLowerCase().equals("y"))
			{
				System.out.println("As you reach into the tub, a disfiguered creature grabs your hand tries pulling you in...");
				System.out.println("It looks like a female, that has been burned with tears of ash. As you push it off, it rises");
				System.out.println("out of the tub. You see razor sharp claws as it comes towards you...\n");
				
				// Start a new battle
				ArrayList<Monster> monsters = new ArrayList<Monster>();
				monsters.add(new Teardrop("Teardrop", 25, 3, null));
				new Battle(player, monsters, "Music/Battle.mp3");
				
				System.out.println("\nWhat the hell was that thing!?");
				System.out.println("The tub begins to drain, revealing a key and some ammo for your pistol.");
				player.addToInventory(new Room208Key()); // Key will unlock the door to leave, for good
				player.addToInventory(new PistolAmmo());
				System.out.println("I have to get out of here...maybe this key will open my door.");
			}
			if (pInput.toLowerCase().equals("n"))
			{
				System.out.print("\n> ");
			}
			
		}
		else 
		{
			System.out.println("There is nothing out of the ordinary");
			System.out.print("\n> ");
		}
	}
}