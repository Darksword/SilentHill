package sh.game;

import java.io.File;
import java.util.Scanner;

import sh.areas.TheRoom;
import sh.areas.otherworld.TheRoom.*;
import sh.entity.weapons.WepPistol;
import sh.shared.Audio;
import sh.shared.Loader;
import sh.shared.Player;
import sh.shared.RoomConnector;
import sh.areas.Test;


@SuppressWarnings("unused")
public class Game 
{

	public Game(Player player)	
	{
		if (player.getRoom() == null) {
			TheRoom theRoom = new TheRoom();
			player.goToRoom(theRoom);
			theRoom.playIntro(player);
			RoomConnector rc = new RoomConnector(player);
		}
		while (true)
		{
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			String pInput = input.nextLine();
			pInput = pInput.toLowerCase();
			
			if (pInput.equals("n")) {
				player.goToRoom(player.getRoom().getNorthExit());
			} else if (pInput.equals("w")) {
				player.goToRoom(player.getRoom().getWestExit());
			} else if (pInput.equals("s")) {
				player.goToRoom(player.getRoom().getSouthExit());
			} else if (pInput.equals("e")) {
				player.goToRoom(player.getRoom().getEastExit());
			} else if (pInput.equals("inventory")) {
				player.checkInventory();
			} else if (pInput.equals("use")) {
				System.out.println("What would you like to use?");
				
				input = new Scanner(System.in);
				pInput = input.nextLine();
				
				player.useFromInventory(pInput.toLowerCase());
			} else if (pInput.equals("health")) {
				System.out.println(player.getHealthStatus());
			} 
			else {
				player.getRoom().examinables(player, pInput);
			}
			
		}
	}	
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
