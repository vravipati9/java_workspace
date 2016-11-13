package sessionbeans.transactionAnnotation;


import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import exception.TestException;

import model.Userdetail;

@Stateless
public class InnerBean {

	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void insertUser(Userdetail ud) throws TestException {
		 em.persist(ud);
		 throw new TestException();
	}
}
