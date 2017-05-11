package ui.googlescholar;

import java.io.Serializable;

import common.SearchEngines;


public class GoogleScholarListItem implements Serializable{
	
	private int id = 0;
	private String title = "";
	private String year;
	private String author;
	private String summary;
	private String citedBy;
	private String url;
	private String type;
	
	public GoogleScholarListItem() {
		this.id = 0;
		this.title = "";
		this.year = "";
		this.author = "";
		this.summary = "";
		this.citedBy = "";
		this.url = "";
		this.type = "";
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		if (author.contains(" - ")){
			this.author = author.split(" - ")[0];
		}
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getCitedBy() {
		return citedBy;
	}
	
	public void setCitedBy(String citedBy) {
		
		this.citedBy = citedBy;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getYear() {
		return year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isBook() {
		
		if (this.type.contains("LIVRO")){
			return true;
		}else{
			return false;
		}
	}

	public void setYear(String year) {
		if (year.contains(" - ")){
			year = year.split(" - ")[1];
			if (year.contains(", ")){
				this.year = year.split(", ")[1]; // ... W Strigel - IEEE software, 2006 - ieeexplore.ieee.org
			}else{
				this.year = year; // E Dustin - 2002 - dl.acm.org
			}
		}
	}

	@Override
	public String toString() {
		return (this.id + SearchEngines.SEPARADOR + this.isBook() + SearchEngines.SEPARADOR + this.title + 
				SearchEngines.SEPARADOR + this.year + SearchEngines.SEPARADOR + this.author + SearchEngines.SEPARADOR
				+this.summary + SearchEngines.SEPARADOR +this.citedBy + SearchEngines.SEPARADOR +this.url);
	}
	
	public String simpleToString() {
		return (this.id + SearchEngines.SEPARADOR + this.isBook() + SearchEngines.SEPARADOR + this.title + 
				SearchEngines.SEPARADOR + this.year + SearchEngines.SEPARADOR + this.citedBy + SearchEngines.SEPARADOR +this.url);
	}
	
	public String authorToString() {
		return (this.id + SearchEngines.SEPARADOR + this.isBook() + SearchEngines.SEPARADOR + this.title + 
				SearchEngines.SEPARADOR + this.year + SearchEngines.SEPARADOR + this.citedBy + SearchEngines.SEPARADOR +this.url);
	}
	
	public String summaryToString() {
		return (this.id + SearchEngines.SEPARADOR + this.isBook() + SearchEngines.SEPARADOR + this.title + 
				SearchEngines.SEPARADOR + this.year + SearchEngines.SEPARADOR + this.citedBy + SearchEngines.SEPARADOR +this.url);
	}
	
	public String getHeaderSimpleToString(){
		return ("id;isBook;title;year;citedBy;url");
	}

}
