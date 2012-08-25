package sh.game;

import java.io.*;
import java.util.ArrayList;
import sh.shared.Items;
import sh.shared.Player;
import sh.shared.Room;
import sh.shared.Weapon;

public class Load{

 @SuppressWarnings("unchecked")
public Load(Player player) {

  // Create the data objects for us to restore.
	 Room currentRoom = player.getRoom();
	 Weapon weapon = player.getWpn();
	 ArrayList <Items> currentInventory = player.getInventory();
  
  // Wrap all in a try/catch block to trap I/O errors.
  try{
   // Open file to read from, named SavedObjects.sav.
   FileInputStream saveFile = new FileInputStream("Assets/Player/sgame.sav");

   // Create an ObjectInputStream to get objects from save file.
   ObjectInputStream save = new ObjectInputStream(saveFile);

   // Now we do the restore.
   // readObject() returns a generic Object, we cast those back
   // into their original class type.
   // For primitive types, use the corresponding reference class.
   currentRoom = (Room) save.readObject();
   weapon = (Weapon) save.readObject();
   currentInventory = (ArrayList<Items>) save.readObject();
   player.goToRoom(currentRoom);
   player.setWpn(weapon);
   player.setInventory(currentInventory);

   // Close the file.
   save.close(); // This also closes saveFile.
  }
  catch(Exception exc){
   exc.printStackTrace(); // If there was an error, print the info.
  }

  // All done.
 }
}