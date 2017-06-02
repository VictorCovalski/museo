package modelo;
import java.util.ArrayList;

/**
 * 
 * @author Guilherme
 *
 */
public class Instituicao {
	
	private String nome;
	private ArrayList<Museu> museus;
	private ArrayList<Usuario> usuarios;
	
	public Instituicao()
	{
		
	}
	public String getNome()
	{
		return nome;
	}
	public String setNome(String nome)
	{
		nome = this.nome;
	}

}
