package modelo;
import java.util.ArrayList;

/**
 * 
 * @author Guilherme
 *
 */
public class Museu {
	
	private String nome;
	private String endereco;
	private ArrayList<Colecao> colecoes;
	
	public Museu()
	{
		
	}
	
	public String getNome()
	{
		return nome;
	}
	public void setNome(String nome)
	{
		nome = this.nome;
	}
	public String getEndereco()
	{
		return endereco;
	}
	public void setEndereco(String endereco)
	{
		endereco = this.endereco;
	}

}
