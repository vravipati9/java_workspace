public class SwitchEx1{
    public static void main(String[] argv){
        final int a = 1;
        int b;
        b = 2;
        int x = 0;
        switch (x) {
          case a:     // ok
         // case b:     // compiler error
        }
    }
}