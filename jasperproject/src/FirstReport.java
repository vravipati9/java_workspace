import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class FirstReport {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws JRException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, JRException, FileNotFoundException {
		Connection con = getconnection();
		
		
 		//Read the .jrxml report template you have designed and create a JasperDesign Object which represent the report design :
 		String report = "D:\\Reports_Tutorial\\report1.jrxml";
 		
 		// Now compile the report design file to create a JasperReport object. The compilation of the report design file validates the JasperReports
 		 //  XML file (EmployeeReport.jrxml) with the jaspereports.dtd DTD and converts the report expressions into a ready-to-evaluate form
		//JasperReport jasperReport = JasperCompileManager.compileReport(report);
		
 		// If we specify compiled report, i.e, jasper no need to compile report again by using compileReport.
		InputStream jasperReport=LoadJasperFile.getReport("report1.jasper");
		
		//To view this, generate a JasperPrint document, which may be viewed, printed or exported to other formats, from the compiled report design
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ReportTitle", "PDF JasperReport by SIVA");
		 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,con);
		 JasperViewer.viewReport(jasperPrint);
		 
		//docX(jasperPrint);
		// A JasperReports report may be exported to a XML file, a PDF file, an HTML file, a CSV file, or an Excel XLS file; 
		 //to export the JasperReports report we’ve just generated to a PDF file, use this
		 
		  OutputStream output = new FileOutputStream(new File("D:\\Reports_Tutorial\\EmployeeReport.pdf"));
		 JasperExportManager.exportReportToPdfStream(jasperPrint, output);
		 

		
		/*String report = "D:\\Reports_Tutorial\\report1.jrxml";
		JasperDesign jasperDesign =JRXmlLoader.load(report);
		String sql = "select * from alarmtype order by severity";
		JRDesignQuery newQuery = new JRDesignQuery();
		newQuery.setText(sql);
		jasperDesign.setQuery(newQuery);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,con);
		JasperViewer.viewReport(jasperPrint);*/
		
		System.out.println("After exec");
	}
	
	static void pdf(JasperPrint jasperPrint) {
		
	}
	static void docX(JasperPrint jasperprint) {
		JRDocxExporter jrDocxExporter = new JRDocxExporter();
		jrDocxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperprint);
		//jrDocxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, )
	}
	static Connection getconnection() throws ClassNotFoundException {
		System.out.println("Oracle JDBC Driver Registered!");
		Connection connection = null;
		try {
			// If we are using Service name instead of sid, synax is 1521/servicename rather than 1521:sid
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.17.221:1521:ampdb", "amplight_2013",
					"amplight_2013");
			return connection;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	
	private Connection getConnection()
    {
    	Connection connection =null;
    	 try {
	    	String driverName = "oracle.jdbc.driver.OracleDriver";
	        Class.forName(driverName);
	        String serverName = "172.23.0.157";
	        String portNumber = "1521";
	        String sid = "amrdb1";
	        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	        String username = "ampweb";
	        String password = "ampweb";
       
	        connection= DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
    }
}
