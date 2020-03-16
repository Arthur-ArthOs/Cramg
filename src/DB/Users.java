package DB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Users implements Serializable{
	private String id;
    private boolean banned;
	
	private static ArrayList<Users> users = new ArrayList<>();
    
	public Users(boolean banned, String id) {
		this.id = id;
		this.banned = banned;
	}
	public static ArrayList<Users> getArray() {
		return users;
	}
	public boolean getBanned() {
		return banned;
	}
	public String getId() {
		return id;		
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static void add(boolean banned, String id) {
		users.add(new Users(banned, id));
	}
	public static void remove(int id) {
		users.remove(id);
		
	}
	public static void ser(){
		try
        {
			FileOutputStream fos= new FileOutputStream("/private/user.cramg");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(users);
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
			FileInputStream fis = new FileInputStream("/private/user.cramg");
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (ArrayList<Users>) ois.readObject();
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
