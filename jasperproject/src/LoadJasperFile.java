import java.io.InputStream;
import net.sf.jasperreports.engine.JRException;

public class LoadJasperFile {
	
	public static InputStream getReport(String reportName) throws JRException{
		System.out.println("reportName: "+reportName);
		return LoadJasperFile.class.getResourceAsStream(reportName);
	}

}
