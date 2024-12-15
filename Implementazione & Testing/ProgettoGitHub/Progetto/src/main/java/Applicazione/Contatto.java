/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applicazione;

/**
 *
 * @author senat
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String numero;
    private String mail;
    private String numero2;
    private String mail2;
    private String numero3;
    private String mail3;
    private int preferito;

   

    public Contatto(String nome, String cognome, String numero, String mail, String numero2, String mail2, String numero3, String mail3, int preferito) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.mail = mail;
        this.numero2 = numero2;
        this.mail2 = mail2;
        this.numero3 = numero3;
        this.mail3 = mail3;
        this.preferito = preferito;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
     public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getNumero3() {
        return numero3;
    }

    public void setNumero3(String numero3) {
        this.numero3 = numero3;
    }

    public String getMail3() {
        return mail3;
    }

    public void setMail3(String mail3) {
        this.mail3 = mail3;
    }
    
    public void setPreferito(int var){
        this.preferito = var;
    }
    
    public int getPreferito(){
        return this.preferito;
    }
}
