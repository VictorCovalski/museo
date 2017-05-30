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
    private ArrayList<String> nomeArtista;

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

    public ArrayList<String> getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(ArrayList<String> nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
    
    
}
