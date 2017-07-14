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
        private String data;
        private String cidade;
        private String estado;
        private String horarioAbertura;
        private String horarioFechamento;
        private String site;
        private String telefone;
	
        public Museu(String nome, String data, String endereco, String cidade, String estado, String fun1, String fun2, String site, String telefone, String descricao)
        {
            this.nome = nome;
            this.data = data;
            this.endereco = endereco;
            this.cidade = cidade;
            this.estado = estado;
            this.horarioAbertura = fun1;
            this.horarioFechamento = fun2;
            this.site = site;
            this.telefone = telefone;
            
        }
        public Museu(String nome)
        {
            this.nome = nome;
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
        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getHorarioAbertura() {
            return horarioAbertura;
        }

        public void setHorarioAbertura(String horarioAbertura) {
            this.horarioAbertura = horarioAbertura;
        }

        public String getHorarioFechamento() {
            return horarioFechamento;
        }

        public void setHorarioFechamento(String horarioFechamento) {
            this.horarioFechamento = horarioFechamento;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }


}
