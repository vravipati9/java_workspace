package sessionbeans.transactionEx;
import javax.ejb.Local;

@Local
public interface TransactionalService {
	void saveRecord();
}
