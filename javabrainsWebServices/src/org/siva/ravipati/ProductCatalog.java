package org.siva.ravipati;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.siva.ravipati.model.Product;
import org.siva.ravipati.service.ProductServiceImpl;

@WebService(name="TestMartCatalog", portName="TestMartCatalogPort" , serviceName="TestMartCatalogService", 
		endpointInterface="org.siva.ravipati.ProductCatalogInterface") 
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService = new ProductServiceImpl();

	/* (non-Javadoc)
	 * @see org.siva.ravipati.ProductCatalogInterface#getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}
	
	/* (non-Javadoc)
	 * @see org.siva.ravipati.ProductCatalogInterface#getProducts(java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category) {
		return productService.getProducts(category.charAt(0));
	}
	
	/* (non-Javadoc)
	 * @see org.siva.ravipati.ProductCatalogInterface#getProductsV2(java.lang.String)
	 */
	@Override
	
	public List<Product> getProductsV2(String category) {
		return productService.getProductsV2(category);
	}
	
	/* (non-Javadoc)
	 * @see org.siva.ravipati.ProductCatalogInterface#addProduct(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category.charAt(0), product);
	}
	
	/* (non-Javadoc)
	 * @see org.siva.ravipati.ProductCatalogInterface#testWebService()
	 */
	@Override
	public String testWebService() {
		return "Web Service working fine";
	}
}
