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
public class Pintura extends Obra{
    private String tecnica;
    private double peso;
    private double comprimento;
    private double largura;
    private double altura;
    private String estadoConservacao;
    private ArrayList<String> autor;

    public Pintura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, String tecnica, double peso, double comprimento, double largura
            , double altura, String estadoConservacao, ArrayList<String> autor) {
        
        super(nome, titulo, paisOrigem, procedencia, material, dataPublicacao, dataAquisicao
                , localEstante, localPrateleira, localNumero);
        this.tecnica = tecnica;
        this.peso = peso;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;
        this.estadoConservacao = estadoConservacao;
        this.autor = autor;
    }
    public Pintura()
    {
    }
    public Pintura(String nome)
    {
        super(nome);
    }
   
    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public ArrayList<String> getAutor() {
        return autor;
    }

    public void setAutor(ArrayList<String> autor) {
        this.autor = autor;
    }
    
    
}
