package com.rsr;


import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Servlet implementation class JasperServlet
 */
public class JasperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JasperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*************Servlet loaded**1*1**********");
		//JasperReport compiledTemplate = null;
	    JRExporter exporter = null;
	    ByteArrayOutputStream out = null;
	    ByteArrayInputStream input = null;


	    try {
	    	System.out.println("************1*1**********");
	    	Connection con = getconnection();
	    	System.out.println("*************Servlet loaded**1*2**********");
	    	
	    	/*
	    	//List<String> sampleList = new ArrayList<String>();
	        //sampleList.add("Fist sample string");
	        //sampleList.add("Second sample string");

	        //JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(sampleList);
	        //Map<String, Object> reportValues = new HashMap<String, Object>();
	        //reportValues.put("anyTestValue", "test value");


	        //FileInputStream file = new FileInputStream("report1.jasper");
	        //compiledTemplate = (JasperReport) JRLoader.loadObject(file);
	    	System.out.println("*************Servlet loaded**1*3**********");
	        out = new ByteArrayOutputStream();
	        
	        System.out.println("<<<<1>>>>");
	        InputStream jasperReport=LoadJasperFile.getReport("D:\\Reports_Tutorial\\report1.jasper");
	       // InputStream jasperReport = new FileInputStream("D:\\Reports_Tutorial\\report1.jasper");
	        Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ReportTitle", "PDF JasperReport by SIVA");
			System.out.println("<<<<2>>2>>");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,con);
			System.out.println("<<<<2>>2>2>");
			JasperViewer.viewReport(jasperPrint);
			//OutputStream output = new FileOutputStream(new File("D:\\Reports_Tutorial\\EmployeeReport.pdf"));
			//JasperExportManager.exportReportToPdfStream(jasperPrint, output);
			 
			 System.out.println("<<<<3>>>>");

	        exporter = new JRPdfExporter();
	        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
	        exporter.exportReport();
	        System.out.println("<<<4>>>");
	        input = new ByteArrayInputStream(out.toByteArray());

	        response.reset();
	        response.setHeader("Content-Type", "application/pdf");
	        response.setHeader("Content-Length", String.valueOf(out.toByteArray().length));
	        response.setHeader("Content-Disposition", "inline; filename=\"fileName.pdf\"");
	        output = new BufferedOutputStream(response.getOutputStream(), 5000);

	        byte[] buffer = new byte[5000];
	        int length;
	        while ((length = input.read(buffer)) > 0) {
	            output.write(buffer, 0, length);
	        }
	        output.flush();
	        */
	    	//Read the .jrxml report template you have designed and create a JasperDesign Object which represent the report design :
	 		String report = "D:\\Reports_Tutorial\\report1.jrxml";
	 		
	 		// Now compile the report design file to create a JasperReport object. The compilation of the report design file validates the JasperReports
	 		 //  XML file (EmployeeReport.jrxml) with the jaspereports.dtd DTD and converts the report expressions into a ready-to-evaluate form
			JasperReport jasperReport = JasperCompileManager.compileReport(report);
			
	 		// If we specify compiled report, i.e, jasper no need to compile report again by using compileReport.
			//InputStream jasperReport=LoadJasperFile.getReport("report1.jasper");
			
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
	    } catch (Exception exception) {
	        exception.printStackTrace();
	    } finally {
	       
	    }
	}
	
	static Connection getconnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			// If we are using Service name instead of sid, synax is 1521/servicename rather than 1521:sid
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.17.221:1521:ampdb", "amplight_2014",
					"amplight_2014");
			
			System.out.println("Oracle JDBC Driver Registered!");
			return connection;
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	

}
