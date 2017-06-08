/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.Arquitetura;
import modelo.Escultura;
import modelo.Obra;
import modelo.Pintura;
import visao.RegistrarObra;

/**
 *
 * @author gleider
 */
public class ControleObras {
    ArrayList<Obra> obras;
    
    public ControleObras(){
        obras = new ArrayList<Obra>();
    }
    public void registrarPintura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> autores, double altura
            , double comprimento, String estado, double largura, double peso, String tecnica){
     
        
        obras.add(new Pintura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao, dataAquisicao
                , localEstante, localPrateleira, localNumero, tecnica, peso, comprimento, largura, altura, estado, autores));
        
      
    }
    public void registrarEscultura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> autores, ArrayList<String> materiais, double altura
            , double comprimento, double espessura, String forma, double largura, double maiorCirc, double menorCirc
            , double peso, double profundidade, String tecnica){
        
        obras.add(new Escultura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas, dataPublicacao, dataAquisicao
            , localEstante, localPrateleira, localNumero, tecnica, forma, materiais, autores, peso, comprimento, largura
            , altura, espessura, profundidade, maiorCirc, menorCirc));
    }
    
    public void registrarArquitetura(String nome, String titulo, String paisOrigem, String procedencia, ArrayList<String> material
            , ArrayList<String> obrasRelacionadas, String dataPublicacao, String dataAquisicao, String localEstante
            , String localPrateleira, int localNumero, ArrayList<String> artistas, String estilo, String linguagem){
        
        obras.add(new Arquitetura(nome, titulo, paisOrigem, procedencia, material, obrasRelacionadas,  dataPublicacao
                , dataAquisicao, localEstante, localPrateleira, localNumero, estilo, linguagem, artistas));
    }
    
    
}
