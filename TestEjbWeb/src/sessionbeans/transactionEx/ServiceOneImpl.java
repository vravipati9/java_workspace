package sessionbeans.transactionEx;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Userdetail;

@Stateless
public class ServiceOneImpl implements ServiceOne {

	@PersistenceContext
	private EntityManager em;
	
    @Override
	public void addRecordFirstRecord() {
    	Userdetail ud = new Userdetail();
    	ud.setUserId(121);ud.setUserName("veera");
		 em.persist(ud);
	}

	@Override
	public void addRecordSecondRecord() {
    	Userdetail ud = new Userdetail();
    	ud.setUserId(122);ud.setUserName("venkata");
		 em.persist(ud);
		 throw new RuntimeException("Rollback Transactional!!");
	}
}
