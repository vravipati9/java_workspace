package sessionbeans.stateful;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class MyBean implements Serializable {

    public MyBean() {
        // TODO Auto-generated constructor stub
    }
    
    private int number = 0;

	public int getNumber() {
		return number;
	}

	public void increment(MyBean myBean) {
		System.out.println("Bean Reference:::"+myBean);
		this.number++;
	}

}
