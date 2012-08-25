package sh.areas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import sh.entity.monsters.Bleeder;
import sh.entity.weapons.*;
import sh.shared.Battle;
import sh.shared.Loader;
import sh.shared.Monster;
import sh.shared.Player;
import sh.shared.Room;
import sh.shared.Audio;

public class TheRoom extends Room 
{
	
	public TheRoom()
	{
		super(null, null, null, null, true);
	}
	
	public void playIntro(Player player)
	{
		// Intro Music
		String filename = "Music/Intro.mp3";
		Audio mp3 = new Audio(filename);
		mp3 = new Audio(filename);
		mp3.play();	
		
		// Intro Text
		String Introduction = Loader.ReadFile(new File("Assets/Content/Intro.text"));
		System.out.print("\n" + Introduction); 
		
		// Wait for player to press enter
		@SuppressWarnings("resource")
		Scanner PlayerInput = new Scanner(System.in);
		System.out.println("\n| Press Enter to Continue |");
		@SuppressWarnings("unused")
		String pInput = PlayerInput.nextLine();
		mp3.close();
		
		// Start battle
		player.setWpn(new WepPistol(1, 4, 6, 5));
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add(new Bleeder("Bleeder", 30, 3, null));
		new Battle(player, monsters, "Music/Battle.mp3");
		
		// After battle
		System.out.print("\nWhat the hell is this thing? Is it dead? I must be losing it. I need to get out of here...but this can't possibly be my apartment?\nBetter take this pistol, could come in handy.\n");
		@SuppressWarnings("resource")
		Scanner EndScene = new Scanner(System.in);
		System.out.println("\n| Press Enter to Continue |");
		@SuppressWarnings("unused")
		String pEnd = EndScene.nextLine();

	}
}