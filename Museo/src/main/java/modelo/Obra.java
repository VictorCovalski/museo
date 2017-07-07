/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.ArrayList;

/**
 *
 * @author gleider
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Pintura.class, name = "Pintura"),
    @JsonSubTypes.Type(value = Escultura.class, name = "Escultura"),
    @JsonSubTypes.Type(value = Arquitetura.class, name = "Arquitetura")}
)

public abstract class Obra {
    private String nome;
    private String identificador;
    private String titulo;
    private String paisOrigem;
    private String procedencia;
    private ArrayList<String> material;
    private String dataPublicacao;
    private String dataAquisicao;
    private String dataCadastro;
    private String localEstante;
    private String localPrateleira;
    private String museu;
    private int localNumero;
    //private Tecnico registradoPor;
    
    
    public Obra(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero){
        
        this.nome = nome;
        this.titulo = titulo;
        this.paisOrigem = paisOrigem;
        this.procedencia = procedencia;
        this.material = material;
        this.dataPublicacao = dataPublicacao;
        this.dataAquisicao = dataAquisicao;
        this.localEstante = localEstante;
        this.localPrateleira = localPrateleira;
        this.localNumero = localNumero;
        
    }
    public Obra()
    {
        
    }
    //Construtor teste
    public Obra(String nome)
    {
        this.nome = nome;
    }
     public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public ArrayList<String> getMaterial() {
        return material;
    }

    public void setMaterial(ArrayList<String> material) {
        this.material = material;
    }

    public ArrayList<String> getObrasRelacionadas() {
        return obrasRelacionadas;
    }

    public void setObrasRelacionadas(ArrayList<String> obrasRelacionadas) {
        this.obrasRelacionadas = obrasRelacionadas;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getLocalEstante() {
        return localEstante;
    }

    public void setLocalEstante(String localEstante) {
        this.localEstante = localEstante;
    }

    public String getLocalPrateleira() {
        return localPrateleira;
    }

    public void setLocalPrateleira(String localPrateleira) {
        this.localPrateleira = localPrateleira;
    }

    public int getLocalNumero() {
        return localNumero;
    }

    public void setLocalNumero(int localNumero) {
        this.localNumero = localNumero;
    }

    public String getMuseu() {
        return museu;
    }

    public void setMuseu(String museu) {
        this.museu = museu;
    }
    
    
    
}