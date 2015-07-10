import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Browser;


public class Testes extends Browser{
	
	@BeforeClass
	public static void setup() throws InterruptedException{
		
		Thread.sleep(2000);
		
		
		
	}
	
//	@Test
	public void testACM() throws InterruptedException, IOException{
		
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		
		for (int i = 1; i <= 17; i++){	
			
			List <WebElement> rows = getDriver().findElements(By.cssSelector("body > div:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr + tr[valign='top']"));

			for (WebElement row : rows){
				out.print(row.findElement(By.cssSelector("td:nth-child(2) table tbody tr:nth-child(1) td a")).getText());
				out.print("___");
				out.print(row.findElement(By.cssSelector("td:nth-child(2) table tbody tr:nth-child(2) td.small-text")).getText());
				out.println("");
			}
			
//			List <WebElement> listaTitle = getDriver().findElements(By.cssSelector("body > div:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > a"));
////			
//			List <WebElement> listaAno = getDriver().findElements(By.cssSelector("body > div:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) td"));
//	
//			int k= 0;
//			for (WebElement element : listaTitle){
//				
//
//				out.print(element.getText());
//				out.print(", ");
//				out.print(listaAno.get(k).getText());
//				out.println("");
//				k++;
//			}
//			
//			System.out.println("");
	
//			for (WebElement element : listaAno){
//				System.out.println(element.getText().split(" ")[1]);
//			}
			if (i < 17){
			WebElement nextPage = getDriver().findElement(By.partialLinkText("next"));
			nextPage.click();
			}
			Thread.sleep(2000);

		}
		
		out.close();
	}
	
	@Test
	public void testScienceDirect() throws InterruptedException, IOException{
		
		PrintStream out = new PrintStream(new FileOutputStream("outputScienceDirect.txt"));
		
		for (int i = 1; i <= 5; i++){	
			
			List <WebElement> rows = getDriver().findElements(By.cssSelector("div.resultList div#searchResults ol.results > li.detail"));

			for (WebElement row : rows){
				out.print(row.findElement(By.cssSelector("li.title h2 a")).getText());
				out.print("___");
				out.print(row.findElement(By.cssSelector("li.source")).getText());
				out.println("");
			}
						
			if (i < 5){
				WebElement nextPage = getDriver().findElement(By.cssSelector("div.paginationBar input.nextPrev[value='Next >>']"));
				nextPage.click();
			}
			
			Thread.sleep(2000);

		}
		
		out.close();
	}
	

	@AfterClass
	public static void tearDown() throws InterruptedException{
		getDriver().close();
	}

}
