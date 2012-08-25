package sh.areas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//import sh.entity.monsters.Bleeder;
import sh.entity.monsters.bosses.Noelle;
import sh.entity.weapons.*;
import sh.shared.Battle;
import sh.shared.Loader;
import sh.shared.Monster;
import sh.shared.Player;
import sh.shared.Room;
//import sh.shared.Audio;

public class Test extends Room 
{
	
	public Test()
	{
		super(null, null, null, null, true);
	}
	
	public void playIntro(Player player)
	{
		// print intro text
		String Introduction = Loader.ReadFile(new File("Assets/Content/NoelleBoss.text"));
		System.out.print(Introduction); 
		// wait for player input before ending intro music track
		@SuppressWarnings("resource")
		Scanner PlayerInput = new Scanner(System.in);
		System.out.println("\n|Press Enter to Continue|");
		@SuppressWarnings("unused")
		String pInput = PlayerInput.nextLine();
		// Initiate the intro fight
		Noelle noelle = new Noelle("Noelle", 250, 3, null);
		player.setWpn(new WepPistol(1, 15, 6, 99));
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		monsters.add(noelle);
		new Battle(player, monsters, "Music/NoelleTheme.mp3");
		//System.out.print("\nWhat the hell is this thing? Is it dead? I must be losing it. I need to get out of here...but where am I?\nBetter take this pistol even though it's out of ammo just in case.\n\n");
	}
}