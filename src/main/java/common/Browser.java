package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	private static WebDriver driver;
	
	//Diretorio do chrome driver
	public static String PATH_TO_CHROME_DRIVER = "/Applications/Selenium/ChromeDriverSelenium/chromedriver";
	
	public static WebDriver getDriver() throws InterruptedException {
		
		if (driver == null){
			
			System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
			
			driver = new ChromeDriver();

			Point targetPosition = new Point(0, 0);
			driver.manage().window().setPosition(targetPosition);

			Dimension targetSize = new Dimension(1280, 800); //resolucao da tela
			driver.manage().window().setSize(targetSize);
							
//			driver.get("http://dl.acm.org/results.cfm?within=%28%22critical+factors%22+OR+%22critical+success+factors%22+OR+CSF+OR+%22crucial+factors%22+OR+risky%29+AND+%28%22agile+software+development%22+OR+agile+OR+lean+OR+scrum+OR+XP+OR+kanban+OR+crystal%29+AND+%28%22software+development%22+OR+%22software+project%22+OR+%22software+process%22%29&CFID=520239650&CFTOKEN=91652223&adv=1&COLL=DL&qrycnt=2387795&DL=ACM&Go.x=39&Go.y=10&termzone=all&allofem=&anyofem=&noneofem=&peoplezone=Name&people=&peoplehow=and&keyword=&keywordhow=AND&affil=&affilhow=AND&pubin=&pubinhow=and&pubby=&pubbyhow=OR&since_year=&before_year=&pubashow=OR&sponsor=&sponsorhow=AND&confdate=&confdatehow=OR&confloc=&conflochow=OR&isbnhow=OR&isbn=&doi=&ccs=&subj=");
			driver.get("http://www.sciencedirect.com/science?_ob=ArticleListURL&_method=tag&searchtype=a&refSource=search&_st=13&count=682&sort=r&filterType=&_chunk=0&hitCount=682&NEXT_LIST=1&view=c&md5=ba732112b7d81bb19a226f93b428cec2&_ArticleListID=-814918956&chunkSize=25&sisr_search=&TOTAL_PAGES=28&zone=exportDropDown&citation-type=RIS&format=cite-abs&bottomPaginationBoxChanged=&displayPerPageFlag=t&resultsPerPage=200");
			
//			Thread.sleep(1000);
//			
//			WebElement dropwdownCondensed = driver.findElement(By.cssSelector("body > div:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > form > select:nth-child(2)"));
//		
//			dropwdownCondensed.click();
//			
//			Thread.sleep(1000);
//			
//			WebElement optionCondensed = dropwdownCondensed.findElement(By.cssSelector("option:nth-of-type(2)"));
//			
//			Thread.sleep(1000);
//			
//			optionCondensed.click();
//			
//			Thread.sleep(1000);
//			
//			WebElement dropwdownOrderBy = driver.findElement(By.cssSelector("body > div:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > form > select:nth-child(1)"));
//
//			dropwdownOrderBy.click();
//			
//			Thread.sleep(1000);
//			
//			WebElement dropdownDate = dropwdownOrderBy.findElement(By.cssSelector("option:nth-of-type(4)"));
//			
//			dropdownDate.click();
			
			Thread.sleep(4000);

		}
		
		return driver;
	}
	
}
