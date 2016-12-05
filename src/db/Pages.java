package db;

import java.util.Date;

public class Pages {
	
	String name;
	Date date;
	String description;
	public Pages(String name, Date date, String description) {
		this.name = name;
		this.date = date;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
