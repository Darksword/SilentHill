package sh.game;

// Java Imports
import java.io.File;
import java.util.Scanner;

// Silent Hill Imports
import sh.areas.TheRoom;
import sh.entity.*;
import sh.entity.weapons.WepPistol;
import sh.shared.*;

// Test Import
import sh.entity.monsters.Bleeder;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Menu 
{
	@SuppressWarnings("resource")
	public static void main (String[] args) 
	{
		Player player = new Player("Player", 50, 2, null, null);
		
		// Title Screen
		String TitleScreen = Loader.ReadFile(new File("Assets/Graphics/Logo.art"));
		System.out.printf(TitleScreen);
		
		// Main Menu Music - The Terminal Show
		String filename = "Music/Menu.mp3"; // Contains the filename that we will play. Always located relative to the game location
		Audio mp3 = new Audio(filename);
	    // Play
        mp3 = new Audio(filename);
        mp3.play();
        
		// Player Options
		System.out.println("\nN: New Game"); 	// Starts a new game
		System.out.println("L: Load Game"); 	// Loads game data...somehow
		System.out.println("O: Options");  		// Normal, Hard?
		System.out.println("Q: Quit"); 			// Quits the game
		
		 
		// Player Input Loop
		while (true)
		{ 
			System.out.print("\n> ");				// Line for input
			Scanner PlayerInput = new Scanner(System.in); 	// Create Scanner titled "PlayerInput"
			String pInput = PlayerInput.nextLine(); 		// Have the String pInput = PlayerInput
			
			// Starts a new game. Intend to add threading so we can just start a new game thread. 
			if (pInput.toLowerCase().equals("n")) 			// Can use lowercase or uppercase. Automatically convert.
			{	
				mp3.close();
				Game newGame = new Game(player);
			}
			
			// Loads a game from a saved file on disk. Doesn't work, because, well....we have nothing to save.
			else if (pInput.toLowerCase().equals("l"))
			{		
				mp3.close();
				Load loadGame = new Load(player);
				Game newGame = new Game(player);
				
			} 
			
			else if (pInput.toLowerCase().equals("o"))
			{
				/*
				System.out.println("Options place holder");
				System.out.println("D: Hard");
				System.out.println("M: Main Menu");
				
				Scanner OptionsInput = new Scanner(System.in); 	// Create Scanner titled "PlayerInput"
				String oInput = PlayerInput.nextLine(); 		// Have the String pInput = PlayerInput
				
				if (oInput.toLowerCase().equals("d"));
				{
					System.out.println(")
				}
				*/
			}
			else if (pInput.toLowerCase().equals("q"))
			{
				//System.out.println("Quit Game?");
				//System.out.println("Y: Yes");
				//System.out.println("N: No");
				System.out.println("And now she'll forever burn...");
				System.exit(0);
				
			}
			// If a player choses a wrong option, we want them to know.
			else 
			{
				System.out.println("> Invalid input!");
			}
		}
	}
	
	// Perform action based on player input
	public static void playerAction(Player player, String input){
		input = input.toLowerCase();
		if (input.equals("n")) {
			player.goToRoom(player.getRoom().getNorthExit());
		} else if (input.equals("w")) {
			player.goToRoom(player.getRoom().getWestExit());
		} else if (input.equals("s")) {
			player.goToRoom(player.getRoom().getSouthExit());
		} else if (input.equals("e")) {
			player.goToRoom(player.getRoom().getEastExit());
		}
	}
}