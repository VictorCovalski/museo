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
public class Arquitetura extends Obra{
    private String estilo;
    private String linguagem;
    private ArrayList<String> Autor;
    
    public Arquitetura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, String estilo, String linguagem, ArrayList<String> nomeArtista){
        
        super(nome, titulo, paisOrigem, procedencia, material, dataPublicacao, dataAquisicao
                , localEstante, localPrateleira, localNumero);
        this.estilo = estilo;
        this.linguagem = linguagem;
        this.Autor = nomeArtista;
    }
    public Arquitetura()
    {
        
    }
    public Arquitetura(String nome)
    {
        super(nome);
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public ArrayList<String> getAutor() {
        return Autor;
    }

    public void setAutor(ArrayList<String> nomeArtista) {
        this.Autor = nomeArtista;
    }
    
    
}
