package org.siva.ravipati.service;


import java.util.ArrayList;
import java.util.List;

import org.siva.ravipati.model.Product;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<String>();
	List<String> musicList = new ArrayList<String>();
	List<String> movieList = new ArrayList<String>();

	public ProductServiceImpl() {
		bookList.add("Inferno");
		bookList.add("Joyland");
		bookList.add("The Game Of Thrones");

		musicList.add("Random Access Memories");
		musicList.add("Night Visions");
		musicList.add("Unorthodox Jukebox");

		movieList.add("Oz the Great and Powerful");
		movieList.add("Despicable Me");
		movieList.add("Star Trek Into Darkness");
	}

	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<String>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		return categories;
	}

	public List<String> getProducts(char category) {
		switch (category) {
		case 'b':
			return bookList;
		case 'm':
			return movieList;
		}
		return null;
	}

	public boolean addProduct(char category, String product) {
		switch (category) {
		case 'b':
			bookList.add(product);
			break;
		case 'm':
			movieList.add(product);
			break;
		default:
			return false;
		}
		return true;
	}
	
	public List<Product> getProductsV2(String category) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("Effective Java", "555", 559.99));
		productList.add(new Product("Head First Design Patterns", "450", 999.99));
		return productList;
	}	
	
}
