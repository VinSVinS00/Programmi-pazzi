/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applicazione;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author senat
 */
public class MostraController implements Initializable {

    @FXML
    private Label LBnome;
    @FXML
    private Label LBcognome;
    @FXML
    private Label LBnumero;
    @FXML
    private Label LBnumero2;
    @FXML
    private Label LBnumero3;
    @FXML
    private Label LBmail;
    @FXML
    private Label LBmail2;
    @FXML
    private Label LBmail3;
    @FXML
    private Button rtn;
    @FXML
    private Button pre;
    
    private String temp;
    private int show; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM contatto WHERE numero='"+temp+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();     
            
             while(rs.next())
                 
             System.out.println(rs.getInt("preferito"));
        
        }catch(Exception e)
        {
          

        }
        
    }   
    
    
    
    
    public void mostra(String num) throws IOException
    {
        temp = num;
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM contatto WHERE numero='"+num+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();
            
                while(rs.next())
                { 
                LBnome.setText(rs.getString("nome"));
                LBcognome.setText(rs.getString("cognome"));
                LBnumero.setText(rs.getString("numero"));
                LBnumero2.setText(rs.getString("numero2"));
                LBnumero3.setText(rs.getString("numero3"));
                LBmail.setText(rs.getString("mail"));
                LBmail2.setText(rs.getString("mail2"));
                LBmail3.setText(rs.getString("mail3"));
                
                }
        
        }catch(Exception e)
        {
          

        }
    }
         

     
    /*public void preferiti(ActionEvent event)
    {
          
            try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="UPDATE public.contatto SET preferito=?  WHERE numero='"+temp+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setInt(1, 1);
            ResultSet rs=pst.executeQuery();     
            if(!rs.next()){
                System.out.println("errore");
            }
            else{
                System.out.println("registrato");
            }
        
        }catch(Exception e)
        {
          

        }
        
    }
    */
    
    public void ritorna(ActionEvent e) throws IOException
    {
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     
     
    
}
    
    
    

