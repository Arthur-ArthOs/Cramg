package DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	public static void ser(){
		try
        {
			FileOutputStream fos= new FileOutputStream("/private/punishment.cramg");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(Autobans);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }

}
	@SuppressWarnings("unchecked")
	public static void deser(){
		try
	      {
			FileInputStream fis = new FileInputStream("/private/punishment.cramg");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Autobans = (ArrayList<String>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
}
