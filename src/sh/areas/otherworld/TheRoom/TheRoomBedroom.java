package sh.areas.otherworld.TheRoom;

import java.util.ArrayList;
import java.util.Scanner;

import sh.entity.monsters.Bleeder;
import sh.entity.weapons.WepPistol;
import sh.shared.Battle;
import sh.shared.Monster;
import sh.shared.Player;
import sh.shared.Room;

public class TheRoomBedroom extends Room{

	public TheRoomBedroom() {
		super(null, null, null, null, true);
		
	}
	public void onEnter()
	{
		// Description
		System.out.println("You enter what used to be your bedroom, now nothing more than dirty blood stained [[bed]] and a [[book]] on the [[night stand]].");
		
		// Player Input
		System.out.println("Rooms:");
		System.out.println("N: Hallway");
		System.out.print("\n> ");
	}
	@SuppressWarnings({ "resource", "unused" })
	public void examinables(Player player, String input) 
	{
		if (input.toLowerCase().contains("bed"))
		{
			System.out.println("You see a box of pistol ammo on the bed, although seven of the twelve bullets are missing.");
			System.out.println("Where'd they go?");
			System.out.println("T: Take");
			System.out.println("L: Leave");
			System.out.print("\n> ");
			
			Scanner bedRoom = new Scanner(System.in);
			String pInput = bedRoom.nextLine();

			if (pInput.toLowerCase().equals("t"))
			{
				System.out.println("You recieve seven pistol ammo!");
				System.out.print("\n> ");
			}
			if (pInput.toLowerCase().equals("l"))
			{
				System.out.print("\n> ");
			}
			
		}
		if (input.toLowerCase().contains("book"))
		{
			System.out.println("You look at the book on the night stand. It's old and worn. You can't make out what the book is.");
			System.out.println("R: Read");
			System.out.println("T: Take");
			System.out.println("L: Leave");
			System.out.print("\n> ");
			
			Scanner bedRoom = new Scanner(System.in);
			String pInput = bedRoom.nextLine();

			if (pInput.toLowerCase().equals("r"))
			{
				// Code to read book
				System.out.print("\n> ");
			}
			if (pInput.toLowerCase().equals("t"))
			{
				System.out.println("You take the book, maybe you'll find time to read it later.");
			}
			if (pInput.toLowerCase().equals("l"))
			{
				
			}
			
		}
		if (input.toLowerCase().contains("night") || input.toLowerCase().contains("stand"))
		{		
			System.out.println("You open the drawer of the night stand and find the other seven bullets with a note.\n");
			System.out.println("''Haha! Hopefully you didn't need these like I needed you. They're all blanks.''");
			System.out.println("\nA bleeder appears from the closet...");
			
			Scanner bedRoom = new Scanner(System.in);
			String pInput = bedRoom.nextLine();
			
			// Battle time
			ArrayList<Monster> monsters = new ArrayList<Monster>();
			monsters.add(new Bleeder("Bleeder", 30, 3, null));
			new Battle(player, monsters, "Music/Battle.mp3");
			System.out.print("\n> ");			
		}
		else 
		{
			//System.out.print("\n> ");
		}
	}
}