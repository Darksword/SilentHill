package sh.areas.otherworld.TheRoom;

import java.util.Scanner;

import sh.game.Save;
import sh.shared.Player;
//import sh.shared.Audio;
import sh.shared.Room;

public class TheRoomOw extends Room 
{
	public TheRoomOw()
	{
		super(null, null, null, null, true);
		
		//String filename = "Music/ApartmentTheme.mp3";
		//Audio mp3 = new Audio(filename);
		//mp3 = new Audio(filename);
		//mp3.play();		
	}	
	
	public void onEnter() {
		// Description Text
		System.out.println("Straight ahead you see your kitchen. Next to you is a blood stained couch which appears old and torn. ");
		System.out.println("There is a tv, with the screen busted out and the floor has turned to metal grating.");
		System.out.println("The dead monster has seemingly dissappeared into thin air, leaving behind no trace.\n");
		System.out.println("You notice a [[symbol]] on the wall, it's that circle with three circles...it makes your head hurt");
		
		
		// Player Input
		System.out.println("Rooms:");
		System.out.println("N: Kitchen\n");
		System.out.print("> ");		
	}
	
	public void examinables(Player player, String input)
	{	
		if (input.equals("symbol")) 
		{
			System.out.println("Do you wish to save your game?");
			
			Scanner plInput = new Scanner(System.in);
			String pInput = plInput.nextLine();
			pInput = pInput.toLowerCase();
			
			if (pInput.equals("yes"))
			{
			    System.out.println("Game saved successfully");
				Save saveGame = new Save(player);
			}
			else if (pInput.equals("no"))
			{
				System.out.println("All saves deleted.");
			}
		}
	}
	
}