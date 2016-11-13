public class Test_CloneTest2 {
    public static void main(String[] args) {
    	CloneTest2  obj = new CloneTest2();
    	CloneTest2 obj3 = obj.clone(); 
    	// compile error. The method clone() from the type Object is not visible
    	// When a protected member is inherited across package it becomes private member of inherited class
    	// the calling class didn't implement clone(). 
    	// CloneTest2 obj, can access objects class clone()
    }
}

