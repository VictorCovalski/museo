/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author gleider
 */
public abstract class Obra {
    private String nome;
    private String titulo;
    private String paisOrigem;
    private String procedencia;
    private ArrayList<String> material;
    private ArrayList<Obra> obrasRelacionadas;
    private String dataPublicacao;
    private String dataAquisicao;
    private String localEstante;
    private String localPrateleira;
    private int localNumero;
    //private Tecnico registradoPor;
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
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

    public ArrayList<Obra> getObrasRelacionadas() {
        return obrasRelacionadas;
    }

    public void setObrasRelacionadas(ArrayList<Obra> obrasRelacionadas) {
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
    
    
    
}
