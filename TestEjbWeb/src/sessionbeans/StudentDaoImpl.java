package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Userdetail;

@Stateless(mappedName="Student")
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext(unitName="TestEjbWeb")
	private EntityManager em;
	
    public StudentDaoImpl() {
    }

    @Override
	public void addRecord() {
		Userdetail ud = em.find(Userdetail.class, 111);
		System.out.println(ud.getUserName());
	}

}
