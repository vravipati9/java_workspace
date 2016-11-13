package sessionbeans.transactionEx;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TransactionalServiceImpl implements TransactionalService {

	@EJB
	ServiceOne serviceOneBean;

	@Override
	public void saveRecord() {
		try {
			serviceOneBean.addRecordFirstRecord();
			serviceOneBean.addRecordSecondRecord();
		} catch (Exception e) {
			System.out.println("IN BEAN CLASS EXCEPTION CAUGHT!!!!!!!!"+e.getMessage());
		}
	}
}
