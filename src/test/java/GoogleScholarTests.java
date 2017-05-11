import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ui.googlescholar.GoogleScholarListItem;
import ui.googlescholar.GoogleScholarPage;
import common.Browser;
import common.SearchEngines;


public class GoogleScholarTests extends Browser{
	
	static GoogleScholarPage page;
		
	@BeforeClass
	public static void setup() throws InterruptedException{
		getDriver().get(SearchEngines.GOOGLE_SCHOLAR_URL);
		
		page = new GoogleScholarPage(getDriver());
		page.searchString();
	}
	
	@Test
	public void testGoogleScholarByPageQuantity() throws IOException {
		
		int pages = 10;

		while (page.getCurrentPage() <= pages){
			page.populateList();
			page.clickNextPageBtn();
		}
		
		this.printItems(page.getItems());
		this.printItems2(page.getItems());
		this.printItems3(page.getItems());
		
	}
	
	private void saveItems(List<GoogleScholarPage> items) throws IOException {

		//Gera o arquivo para armazenar o objeto
		FileOutputStream arquivoGrav = new FileOutputStream("resultado.csv");

		//Classe responsavel por inserir os objetos
		ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);

		//Grava o objeto cliente no arquivo
		objGravar.writeObject(items);

		objGravar.flush();
		objGravar.close();
		arquivoGrav.flush();
		arquivoGrav.close();
		System.out.println("Objeto gravado com sucesso! \n");

	}
	
	private void printItems(List<GoogleScholarListItem> items) throws FileNotFoundException {

		//Gera o arquivo para armazenar o objeto
		PrintStream out = new PrintStream(new FileOutputStream("simple_output.csv"));

		//adding header
		out.println("id;isBook;title;year;citedBy;url");
		
		for (GoogleScholarListItem item : items) {
//			System.out.println(item.toString());
			out.println(item.simpleToString());
		}
		
		out.close();

	}
	
	private void printItems2(List<GoogleScholarListItem> items) throws FileNotFoundException {

		//Gera o arquivo para armazenar o objeto
		PrintStream out = new PrintStream(new FileOutputStream("author_output.csv"));

		//adding header
		out.println("id;author");
		
		for (GoogleScholarListItem item : items) {
//			System.out.println(item.toString());
			out.println(item.authorToString());
		}
		
		out.close();

	}
	
	private void printItems3(List<GoogleScholarListItem> items) throws FileNotFoundException {

		//Gera o arquivo para armazenar o objeto
		PrintStream out = new PrintStream(new FileOutputStream("summary_output.csv"));

		//adding header
		out.println("id;summary");
		
		for (GoogleScholarListItem item : items) {
//			System.out.println(item.toString());
			out.println(item.summaryToString());
		}
		
		out.close();

	}
	
	@AfterClass
	public static void tearDown(){
		getDriver().close();
	}
	
	

}
