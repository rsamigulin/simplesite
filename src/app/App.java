package app;

//import static util.CryptoUtil.sha256Hash;

//import static ab.v6.model.Const.PSW_SALT;
//import static util.CryptoUtil.sha256Hash;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import db.Catalog;
import db.DataBase;
import db.PageDescription;
import db.Product;

public class App {
	
	private Catalog catalog;
	private DataBase db;
	private PageDescription pageDescription;
	
	public void init(DataBase db){
		this.db = db;
		this.catalog = new Catalog(this.db);
		this.pageDescription = new PageDescription(this.db);
	}
	
	public synchronized List<Product> getProducts(){
		return catalog.getProducts();
	}
	
	public DataBase getDatabase(){
		return db;
	}
	
	public Catalog getCatalog(){
		return catalog;
//		return new Catalog(db);
	}
	
	public PageDescription getPageDescription(){
//		return new PageDescription(db);
		return pageDescription;
	}
}
