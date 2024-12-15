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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author senat
 */
public class ModificaController implements Initializable {

    @FXML
    private Label LBnome;
    @FXML
    private TextField TXnome;
    @FXML
    private TextField TXcognome;
    @FXML
    private TextField TXnumero2;
    @FXML
    private TextField TXnumero;
    @FXML
    private TextField TXnumero3;
    @FXML
    private TextField TXmail;
    @FXML
    private TextField TXmail2;
    @FXML
    private TextField TXmail3;
    @FXML
    private Button save;
    @FXML
    private Button ann;
    @FXML
    private Button pref;
    
    private String temp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
        public void preferiti(ActionEvent event) throws ClassNotFoundException, SQLException
    {
            String sqlname2="www";
            String sqlpassword2="tw2024";
            String sqlquery2 = "SELECT * FROM contatto WHERE numero = '"+temp+"'";
            Class.forName("org.postgresql.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname2,sqlpassword2);
            PreparedStatement pst2= con2.prepareStatement(sqlquery2);
            ResultSet rs2 = pst2.executeQuery();
            while(rs2.next()){
                Alert alertPref = new Alert(AlertType.INFORMATION);
                alertPref.setTitle("ERRORE");
                alertPref.setHeaderText("Errore di selezione");
                alertPref.setContentText("Contatto già preferito");
                if(rs2.getInt("preferito") == 1){
                    if(alertPref.showAndWait().get() == ButtonType.OK){
                    }
                }
            }
            
            try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="UPDATE public.contatto SET preferito=?  WHERE numero='"+temp+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setInt(1, 1);
            ResultSet rs=pst.executeQuery();     
        
        }catch(Exception e)
        {
            
        }
    }
    
    public void mostra(String num)  throws IOException
    {
        temp=num;
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
                LBnome.setText(rs.getString("nome")+" "+rs.getString("cognome"));
                TXnome.setText(rs.getString("nome"));
                TXcognome.setText(rs.getString("cognome"));
                TXnumero.setText(rs.getString("numero"));
                TXnumero2.setText(rs.getString("numero2"));
                TXnumero3.setText(rs.getString("numero3"));
                TXmail.setText(rs.getString("mail"));
                TXmail2.setText(rs.getString("mail2"));
                TXmail3.setText(rs.getString("mail3"));
                
                }
        
        }catch(Exception e)
        {
          

        }
    }
    
    public void modifica(ActionEvent event) throws IOException
    {
        String nome=TXnome.getText();
        String cognome=TXcognome.getText();
        String numero=TXnumero.getText();
        String email=TXmail.getText();
        String numero2=TXnumero2.getText();
        String email2=TXmail2.getText();
        String numero3=TXnumero3.getText();
        String email3=TXmail3.getText();
        
        Alert alertName = new Alert(Alert.AlertType.INFORMATION);
        alertName.setTitle("ERRORE");
        alertName.setHeaderText("Errore inserimento");
        alertName.setContentText("Campo nome non compilato");
        
        Alert alertNum = new Alert(Alert.AlertType.INFORMATION);
        alertNum.setTitle("ERRORE");
        alertNum.setHeaderText("Errore inserimento");
        alertNum.setContentText("Campo numero non compilato");
        
        Alert alertMail = new Alert(Alert.AlertType.INFORMATION);
        alertMail.setTitle("ERRORE");
        alertMail.setHeaderText("Errore inserimento");
        alertMail.setContentText("Campo mail non valido");
        
        if(TXnome.getText().isEmpty()){
            if(alertName.showAndWait().get() == ButtonType.OK){
            }
        }
        
        else if(!TXmail.getText().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            if(alertMail.showAndWait().get() == ButtonType.OK){
            }
        }
        
        else if(TXnumero.getText().isEmpty()){
            if(alertNum.showAndWait().get() == ButtonType.OK){
            }
        }
        
        else
        {
        try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="UPDATE public.contatto SET nome=?, cognome=?, numero=?, mail=?, numero2=?, mail2=?, numero3=?, mail3=? WHERE numero='"+temp+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setString(1, nome);
            pst.setString(2, cognome);
            pst.setString(3, numero);
            pst.setString(4, email);
            pst.setString(5, numero2);
            pst.setString(6, email2);
            pst.setString(7, numero3);
            pst.setString(8, email3);
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
        
        Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }
    
     
    public void annulla(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
   
    
}
