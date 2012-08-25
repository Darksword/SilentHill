package sh.shared;

import java.io.Serializable;

import sh.shared.*;

@SuppressWarnings("unused")
public class Room implements Serializable
{
	
	private Room northExit;
	private Room eastExit;
	private Room southExit;
	private Room westExit;
	private boolean isInOtherWorld;
	
	// Room Constructor, a template for all other rooms to be based off of.
	public Room (Room nExit, Room eExit, Room sExit, Room wExit, boolean inOtherWorld)
	{
		northExit = nExit; 		// North Room Exit. Default: null
		eastExit = eExit; 			// East Room Exit. Default: null
		southExit = sExit; 		// South Room Exit. Default: null
		westExit = wExit; 			// West Room Exit. Default: null
		isInOtherWorld = inOtherWorld; 
	}	
	
	// This is bullshit below this line
	//-----------------------------------
	public Room getNorthExit()
	{
		return northExit;
	}
	public void setNorthExit(Room room){
		northExit = room;
	}
	public Room getEastExit()
	{
		return eastExit;
	}
	public void setEastExit(Room room){
		eastExit = room;
	}
	public Room getSouthExit()
	{
		return southExit;
	}
	public void setSouthExit(Room room){
		southExit = room;
	}
	public Room getWestExit()
	{
		return westExit;
	}
	public void setWestExit(Room room){
		westExit = room;
	}
	public boolean hasExits(){
		if (northExit == null && eastExit == null && southExit == null && westExit == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void onEnter()
	{
		
	}
	
	private void onExit()
	{
		
	}

	public void examinables(Player player, String pInput) {
		// Examinables for each room
	}

}
