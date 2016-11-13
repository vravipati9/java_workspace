package sessionbeans.beanMangedTx;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Userdetail;

@Stateless
@javax.ejb.ApplicationException(rollback = false)
@TransactionManagement(TransactionManagementType.BEAN)
@Remote
public class BeanManagedTxServiceImpl implements BeanManagedTxService, Serializable {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;
	@Override
	public void insertRecord() {
		try {
			int dummy = 0;
			utx.begin();
			Userdetail ud = new Userdetail();
			ud.setUserId(122);ud.setUserName("ravi");
			
			Userdetail ud1 = new Userdetail();
			ud1.setUserId(123);ud1.setUserName("pati");

			em.persist(ud);
			
			/*if (dummy == 0) 
			throw new EJBException();
			*/
			em.persist(ud1);
			utx.commit();
			
		} catch (Exception e) {
			System.out.println("IN BEAN CLASS EXCEPTION CAUGHT!!!!!!!!");
			e.printStackTrace();
		}
	}
}
