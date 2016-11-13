package sessionbeans.beanMangedTx;
import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface BeanManagedTxService {
	void insertRecord();
}
