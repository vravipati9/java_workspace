import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

class Sheep implements Cloneable {

	@Override
    public Object clone() throws CloneNotSupportedException {
        return new Sheep(); // bad, doesn't cascade up to Object
    }
}

public class WoolySheep extends Sheep {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public static void main(String a[]) throws CloneNotSupportedException {
    	WoolySheep dolly = new WoolySheep();
    	WoolySheep clone = (WoolySheep)dolly.clone(); // error
    	System.out.println(clone.getClass());
    }
}