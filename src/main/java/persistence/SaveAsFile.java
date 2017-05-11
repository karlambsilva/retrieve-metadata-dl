package persistence;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import ui.googlescholar.GoogleScholarListItem;

public class SaveAsFile {

	public void saveItems(List<GoogleScholarListItem> items) throws IOException {

		//Gera o arquivo para armazenar o objeto
		FileOutputStream arquivoGrav = new FileOutputStream("resultado.txt");

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

}
