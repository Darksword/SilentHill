package sh.game;

import java.io.*;
import java.util.ArrayList;
import sh.shared.Items;
import sh.shared.Player;
import sh.shared.Room;
import sh.shared.Weapon;

public class Save{

  public Save(Player player){
	  
    // Create some data objects for us to save.
    Room currentRoom = player.getRoom();
	Weapon weapon = player.getWpn();
    ArrayList <Items> currentInventory = player.getInventory();

    try{  // Catch errors in I/O if necessary.
      // Open a file to write to, named SavedObjects.sav.
      FileOutputStream saveFile=new FileOutputStream("Assets/Player/sgame.sav");

      // Create an ObjectOutputStream to put objects into save file.
      ObjectOutputStream save = new ObjectOutputStream(saveFile);

      // Now we do the save.
      save.writeObject(currentRoom);
      save.writeObject(weapon);
      save.writeObject(currentInventory);
      // Close the file.
      save.close(); // This also closes saveFile.
      
    }
    catch(Exception exc){
      exc.printStackTrace(); // If there was an error, print the info.
    }
  }
}
