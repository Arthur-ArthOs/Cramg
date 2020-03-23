package DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Invites {
	private String Link;
	private String Guild;
	private String id;
	
	private static ArrayList<Invites> invites = new ArrayList<>();
    
	public Invites(String Link, String Guild, String id) {
		this.Link = Link;
		this.Guild = Guild;
		this.id = id;
	}
	public static ArrayList<Invites> getArray() {
		return invites;
	}
	public String getLink() {
		return Link;
	}
	public String getId() {
		return id;		
	}
	public String getGuild() {
		return Guild;
	}
	public void setLink(String Link) {
		this.Link = Link;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGuild(String Guild) {
		this.Guild = Guild;
	}
	public static void add(String Link, String Guild, String id) {
		invites.add(new Invites(Link, Guild, id));
	}
	public static void remove(int id) {
		invites.remove(id);
	}
	public static void ser(){
		try
        {
			FileOutputStream fos= new FileOutputStream("/private/punishment.cramg");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(invites);
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
            invites = (ArrayList<Invites>) ois.readObject();
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
