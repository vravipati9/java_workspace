package sessionbeans;
import javax.ejb.Local;

@Local
public interface AccountStatelessBeanLocal {
	public void deposit(int amount);
	
	public int withdraw(int amount);
	
	public int getBalance();
}
