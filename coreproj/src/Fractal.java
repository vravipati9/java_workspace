public class Fractal{   
  
     public static void main(String args[]){   
          Fractal ft=new SubFractal();   
          String s=((Fractal)ft.getOb()).getMsg();
          //String s=(Fractal)ft.getOb().getMsg();	// compilation fails
          System.out.print(s);     
     }   
  
     public Object getOb(){   
          return new Fractal();   
     }   
  
     public String getMsg(){   
          return "SuperStar";   
     }   
  
}   
  
  
class SubFractal extends Fractal{   
  
     public Fractal getOb(){   
          return new Fractal();   
     }   
  
     public String getMsg(){   
          return "SubStar";   
     }   
}  

abstract class Shape {
	public abstract void draw();
}
abstract class Circle extends Shape {
	public abstract void draw();
}
