
public class CloneTest {

	public static void main(String[] args) {
		Rect rec = new Rect(30, 60);
		Rect copy = null;
        try {
            System.out.println("Creating Copy of this object using Clone method");
            copy = (Rect)rec.clone();
            System.out.println("Copy Class::" + copy.getClass());
          
        } catch (CloneNotSupportedException ex) {
        	System.out.println("Cloning is not supported for this object");
        }
        System.out.println("copy != rec : " + (copy != rec));
        System.out.println("copy.getClass() == rec.getClass() : " + (copy.getClass() == rec.getClass()));
        System.out.println("copy.equals(rec) : " + copy.equals(rec));
      
        //Updating fields in original object
        //copy.setHeight(100);
        //copy.setWidth(45);
      
        System.out.println("Original object :" + rec);
        System.out.println("Clonned object  :" + copy);

        
	}
}
