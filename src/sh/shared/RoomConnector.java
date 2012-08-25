package sh.shared;

import sh.areas.otherworld.TheRoom.*;

public class RoomConnector {

	public RoomConnector(Player player)
	{
		TheRoomBathroom trBathroomOw = new TheRoomBathroom();
		TheRoomBedroom trBedroomOw = new TheRoomBedroom();
		TheRoomHallway trHallwayOw = new TheRoomHallway();
		TheRoomKitchen trKitchenOw = new TheRoomKitchen();
		TheRoomOw trLivingOw = new TheRoomOw();
		
		// Connect rooms to TheRoomBathroom
		trBathroomOw.setSouthExit(trHallwayOw);
		
		// Connect rooms to TheRoomBedroom
		trBedroomOw.setNorthExit(trHallwayOw);
		
		// Connect rooms to TheRoomHallway
		trHallwayOw.setNorthExit(trBathroomOw);
		trHallwayOw.setSouthExit(trBedroomOw);
		trHallwayOw.setEastExit(trKitchenOw);
		
		// Connect rooms to TheRoomKitchen
		trKitchenOw.setWestExit(trHallwayOw);
		trKitchenOw.setSouthExit(trLivingOw);
		//trKitchen.setNorthExit(awHallway2F);
		
		// Connect rooms to TheRoomOw
		trLivingOw.setNorthExit(trKitchenOw);
		
		// Put player in a room
		player.goToRoom(trLivingOw);
	}
	
}
