import java.io.IOException;

interface MOne1 {
	public void mOne();
}

abstract class MOneCls implements MOne1 {
	public abstract void mOne();
}



class SupN {
	public void mOne() throws Exception {
		System.out.println("In Mone");
		throw new IOException();
	}
}

class SubN extends SupN {
	public void mOne() throws IOException { 
		System.out.println("In Mone Sub");
	}
}
public class TestN {

	public static void main(String[] args) throws Exception
	{
		SupN obj = new SubN();
		obj.mOne();
	}
}
