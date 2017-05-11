package ui.googlescholar;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.SearchEngines;

public class GoogleScholarPage {
	
    private final WebDriver driver;
	
    // page general locators
    By currentPage = By.cssSelector("#gs_ccl_bottom table td .gs_ico_nav_current~b");
    By searchInput = By.id("gs_hdr_frm_in_txt");
    By searchButton = By.id("gs_hdr_tsb");
    
    By pageNumber = By.cssSelector("#gs_ccl_bottom table td");

    By itemLocator = By.cssSelector("#gs_ccl_results .gs_r");

    // item locators
    By title = By.cssSelector(".gs_ri h3 a");
    By titleNotLink = By.cssSelector(".gs_ri h3");
    By type = By.cssSelector(".gs_ri .gs_rt .gs_ct1");
    By author = By.cssSelector(".gs_ri .gs_a");
    By summary = By.cssSelector(".gs_ri .gs_rs");
    By citedBy = By.cssSelector(".gs_ri .gs_fl a[href^='/scholar?cites=']");
    
    List <String> string2 = new ArrayList<String>();

    List <GoogleScholarListItem> items = new ArrayList<GoogleScholarListItem>();
    
    public GoogleScholarPage(WebDriver driver) {
		this.driver = driver;
	}
    
    public GoogleScholarPage searchString() throws InterruptedException{
    	driver.findElement(searchInput).sendKeys(SearchEngines.SEARCH_STRING);
    	driver.findElement(searchButton).click();
    	    	
    	return this;
    }
    
    public void populateList(){
    	
    	List<WebElement> list = driver.findElements(itemLocator);

    	for (WebElement webElement : list) {
    		
    		GoogleScholarListItem item = new GoogleScholarListItem();

    		try{
        		item.setTitle(webElement.findElement(title).getText());
        		item.setUrl(webElement.findElement(title).getAttribute("href"));
    		}catch (NoSuchElementException exc){ // title is not a link
        		item.setTitle(webElement.findElement(titleNotLink).getText());
    		}
    		
    		item.setAuthor(webElement.findElement(author).getText());
    		item.setYear(webElement.findElement(author).getText());
    		item.setCitedBy(webElement.findElement(citedBy).getText());
    		
    		try{ // there is no type or summary
        		item.setSummary(webElement.findElement(summary).getText());
    			item.setType(webElement.findElement(type).getText());
    		}catch (NoSuchElementException exc){

    		}
    		item.setId(items.size() + 1);
    		items.add(item);
		}
    	
    }
    
    public int getCurrentPage(){
    	String pageNumber = driver.findElement(currentPage).getText();
    	return Integer.parseInt(pageNumber);
    }
    
    public GoogleScholarPage clickNextPageBtn(){
    	
        By nextPageLocator = By.linkText(getCurrentPage() + 1 + "");
        
		for ( WebElement pageNumberIcon : driver.findElements(pageNumber)) {
			try{
				pageNumberIcon.findElement(nextPageLocator).click();
				break;
			} catch (NoSuchElementException exc){
				
			}
		}
		
    	return this;
    }
    
//    public List<String> getString2() {
//		return string2;
//	}

	public List<GoogleScholarListItem> getItems() {
		return items;
	}

}
