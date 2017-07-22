/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
/**
 *
 * @author tech
 */
public abstract class Usuario {
    protected String nome;
    protected String cpf;
    protected String email;

   
    protected String senha;
    protected String permissaoCadastro[];
    protected String museusPermitidos[];
    
    public void setMuseusPermitidos(String m[])
    {
        museusPermitidos = m.clone();
    }
    public String[] getMuseusPermitidos()
    {
        return museusPermitidos.clone();
    }
    public String[] getPermissaoCadastro() {
        return permissaoCadastro;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void showMuseus(){
        for(int i = 0; i < museusPermitidos.length; i++){
            System.out.println(museusPermitidos[i]);
        }
    }
}
