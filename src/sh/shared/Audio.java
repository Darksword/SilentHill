package sh.shared;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;


public class Audio 
{
	private String filename;
	private Player player; 

	// constructor that takes the name of an MP3 file
	public Audio(String filename) 
	{
		this.filename = filename;
	}

	public void close() 
	{ 
		if (player != null) player.close(); 
	}

	// play the MP3 file to the sound card
	public void play() 
	{
		try 
		{
			FileInputStream fis     = new FileInputStream(filename);
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        player = new Player(bis);
	    }
	    catch (Exception e) 
	    {
	        System.out.println("Problem playing file " + filename);
	        System.out.println(e);
	    }

	    // run in new thread to play in background
	    new Thread() 
	    {
	    	public void run() 
	    	{
	    		try 
	    		{ 
	    			player.play(); 
	    		}
	    		catch (Exception e) 
	    		{ 
	    			System.out.println(e); 
	    		}
	        }
	    }
	    .start();
	 }
}