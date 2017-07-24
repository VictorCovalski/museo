package modelo;
import java.util.ArrayList;

/**
 * 
 * @author Guilherme
 *
 */

public class Colecao {
	
	private String nome;
        private String data;
        private String museu;
        private String descricao;
	
        public Colecao()
        {
            
        }
	public Colecao(String nome, String data, String museu, String descricao)
	{
		this.nome = nome;
                this.data = data;
                this.museu = museu;
                this.descricao = descricao;
	}
	
	public void setNome(String nome)
	{
		nome = this.nome;
	}
	public String getNome()
	{
		return nome;
	}

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getMuseu() {
            return museu;
        }

        public void setMuseu(String museu) {
            this.museu = museu;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
        
	

}
