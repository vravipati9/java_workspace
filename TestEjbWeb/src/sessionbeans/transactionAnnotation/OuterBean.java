package sessionbeans.transactionAnnotation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Userdetail;

@Stateless
public class OuterBean {
	@EJB InnerBean innerBean;
	@PersistenceContext EntityManager em;
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertUser() {
		Userdetail ud = new Userdetail();
		ud.setUserId(125);ud.setUserName("abc");
		Userdetail ud1 = new Userdetail();
		ud1.setUserId(126);ud1.setUserName("abcdefg");

		em.persist(ud);
		try {
			innerBean.insertUser(ud1);
		} catch (Exception e) {
			System.out.println("IN BEAN CLASS EXCEPTION CAUGHT!!!!!!!!"+e.getMessage());
		}
	}
}
