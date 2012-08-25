package sh.shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Loader {
	public static String ReadFile(File f){
	    String str,buff = "";
		try {
		    BufferedReader in = new BufferedReader(new FileReader(f));

		    while ((str = in.readLine()) != null) {
		        buff=buff+str+"\n";
		    }
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buff;
	}
}
