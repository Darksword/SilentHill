package sh.areas.otherworld.TheRoom;

import sh.shared.Player;
import sh.shared.Room;

public class TheRoomHallway extends Room{

	public TheRoomHallway() {
		super(null, null, null, null, true);
		
			
		
	}
	public void onEnter()
	{
		// Description
		System.out.println("The hallway leads to the bathroom and bedroom.");
		System.out.println("There is a [[picture]] of you and Noelle on the wall.\n");
		
		// Player Input
		System.out.println("Rooms:");
		System.out.println("E: Kitchen");
		System.out.println("N: Bathroom");
		System.out.println("S: Bedroom");
		System.out.print("\n> ");
	}
	public void examinables(Player player, String input) 
	{
		if (input.toLowerCase().contains("picture"))
		{
			System.out.println("It's a picture a few days before the incident. We were on a mini-vacation to visit her father up north.");
			System.out.print("\n> ");
		}
		else 
		{
			System.out.println("There is nothing out of the ordinary");
			System.out.print("\n> ");
		}
	}
}