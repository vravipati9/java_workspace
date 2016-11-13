package org.siva.ravipati;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.siva.ravipati.model.Product;

@WebService(name="TestMartCatalog", portName="TestMartCatalogPort" , serviceName="TestMartCatalogService" ) 
public interface ProductCatalogInterface {

	@WebMethod(action = "fetch_Categories", operationName = "fetchCategories")
	public abstract List<String> getProductCategories();
	
	@WebMethod
	public abstract List<String> getProducts(String category);

	@WebMethod
	@WebResult(name="product")
	public abstract List<Product> getProductsV2(String category);

	@WebMethod
	public abstract boolean addProduct(String category, String product);

	@WebMethod
	public abstract String testWebService();

}