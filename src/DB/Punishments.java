package DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Punishments implements Serializable{
	private String Name;
	private String Reason;
	private String id;
	
	private static ArrayList<Punishments> punishments = new ArrayList<>();
    
	public Punishments(String Name, String Reason, String id) {
		this.Name = Name;
		this.Reason = Reason;
		this.id = id;
	}
	public static ArrayList<Punishments> getArray() {
		return punishments;
	}
	public String getName() {
		return Name;
	}
	public String getId() {
		return id;		
	}
	public String getReason() {
		return Reason;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setReason(String Reason) {
		this.Reason = Reason;
	}
	public static void add(String Name, String Reason, String id) {
		punishments.add(new Punishments(Name, Reason, id));
	}
	public static void remove(int id) {
		punishments.remove(id);
		
	}
	public static void ser(){
		try
        {
			FileOutputStream fos= new FileOutputStream("/private/punishment.cramg");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(punishments);
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
            punishments = (ArrayList<Punishments>) ois.readObject();
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
