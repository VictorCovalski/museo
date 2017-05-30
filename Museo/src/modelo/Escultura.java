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
public class Escultura extends Obra{
    private String tecnica;
    private String forma;
    private ArrayList<String> materialUtilizado;
    private ArrayList<String> autor;
    private double peso;
    private double comprimento;
    private double largura;
    private double altura;
    private double espessura;
    private double profundidade;
    private double circunferenciaMaior;
    private double circunferenciaMenor;

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public ArrayList<String> getMaterialUtilizado() {
        return materialUtilizado;
    }

    public void setMaterialUtilizado(ArrayList<String> materialUtilizado) {
        this.materialUtilizado = materialUtilizado;
    }

    public ArrayList<String> getAutor() {
        return autor;
    }

    public void setAutor(ArrayList<String> autor) {
        this.autor = autor;
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

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public double getCircunferenciaMaior() {
        return circunferenciaMaior;
    }

    public void setCircunferenciaMaior(double circunferenciaMaior) {
        this.circunferenciaMaior = circunferenciaMaior;
    }

    public double getCircunferenciaMenor() {
        return circunferenciaMenor;
    }

    public void setCircunferenciaMenor(double circunferenciaMenor) {
        this.circunferenciaMenor = circunferenciaMenor;
    }
    
    
}
