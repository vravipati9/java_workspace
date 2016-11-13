public class CloneTest2 {  
    public static void main(String[] args) {    
        try {
        	CloneTest2  obj = new CloneTest2();
        	CloneTest2 obj3 = (CloneTest2)obj.clone(); // calling super class clone()        
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

