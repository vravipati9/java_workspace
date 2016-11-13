package sessionbeans.transactionEx;
import javax.ejb.Local;

@Local
public interface ServiceOne {
	void addRecordFirstRecord();
	void addRecordSecondRecord();
}
