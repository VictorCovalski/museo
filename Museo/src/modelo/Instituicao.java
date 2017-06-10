package modelo;
import java.util.ArrayList;
import controle.Principal;

/**
 * 
 * @author Guilherme
 *
 */
public class Instituicao {
	
	private String nome;
	private String endereco;
	private ArrayList<Museu> museus;
	private ArrayList<Usuario> usuarios;
	
	public Instituicao(){
            this.nome = "Universidade Federal de Pelotas";
            this.endereco = "Av. Gomes Carneiro, 1";
            museus = new ArrayList<>();
            usuarios = new ArrayList<>();
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
