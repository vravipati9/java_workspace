package sessionbeans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class AccountStatelessBean
 */
@Stateless
public class AccountStatelessBean implements AccountStatelessBeanLocal {
	
	int amt = 1000;
    /**
     * Default constructor. 
     */
    public AccountStatelessBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void deposit(int amount) {
		amt += amount;
	}

	@Override
	public int withdraw(int amount) {
		// TODO Auto-generated method stub
		return amt -= amount;
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return amt;
	}

}
