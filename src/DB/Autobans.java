package DB;

import java.util.ArrayList;

public class Autobans {
	static ArrayList<String> Autobans = new ArrayList<>();
    public static boolean usesAutoban(String Id) {
    	if(Autobans.contains(Id)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    public static void add(String Id) {
    	Autobans.add(Id);
    }
    public static void remove(String Id) {
    	int i = 0;
    	for (String id : Autobans) {
    		if(id.equalsIgnoreCase(Id)) {
    			Autobans.remove(i);
    			return;
    		}
    		i++;
    	}
    }
}
