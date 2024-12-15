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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author senat
 */
public class ArchivioController implements Initializable {

    @FXML
    private Button sp;
    @FXML
    private Button rtn;
    @FXML
    private TableView<Contatto> Archivio;
    @FXML
    private TableColumn<Contatto,String> Tnome;
    @FXML
    private TableColumn<Contatto,String> Tcognome;
    @FXML
    private TableColumn<Contatto,String> Tnumero;
    @FXML
    private TableColumn<Contatto,String> Tmail;
    
    private ObservableList<Contatto> archivio= FXCollections.observableArrayList();;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        
        Tnome.setCellValueFactory(new PropertyValueFactory("nome"));
        Tcognome.setCellValueFactory(new PropertyValueFactory("cognome"));
        Tnumero.setCellValueFactory(new PropertyValueFactory("numero"));
        Tmail.setCellValueFactory(new PropertyValueFactory("mail"));
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM archivio ORDER BY nome ";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            Archivio.setItems(archivio);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                archivio.add(new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"),rs.getInt("preferito")));
            }
            
            }catch(Exception e){
          
        }   
    }

    public void archivia(String num)
    {
         Contatto temp=null;
        
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
                    temp=new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"),rs.getInt("preferito"));
                
                }
        
        }catch(Exception e)
        {
            
        }
         
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="DELETE FROM contatto WHERE numero='"+num+"' ";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            
            ResultSet rs=pst.executeQuery();
            if(!rs.next()){
                System.out.println("errore");
            }
            else{
                System.out.println("registrato");
            }
            }catch(Exception e){
                
            }
         
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="INSERT INTO archivio (nome, cognome, numero, mail, numero2, mail2, numero3 ,mail3,preferito)VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setString(1, temp.getNome());
            pst.setString(2, temp.getCognome());
            pst.setString(3, temp.getNumero());
            pst.setString(4, temp.getMail());
            pst.setString(5, temp.getNumero2());
            pst.setString(6, temp.getMail2());
            pst.setString(7, temp.getNumero3());
            pst.setString(8, temp.getMail3());
            pst.setInt(9, temp.getPreferito());
             
            
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

     public void sposta(ActionEvent event)
    {
         if(event.getSource() == sp){
             
             Contatto temp=null;
        
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="SELECT * FROM archivio WHERE numero='"+Archivio.getSelectionModel().getSelectedItem().getNumero()+"'";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            ResultSet rs=pst.executeQuery();
            
                while(rs.next())
                { 
                    temp=new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("numero"),rs.getString("mail"),rs.getString("numero2"),rs.getString("mail2"),rs.getString("numero3"),rs.getString("mail3"),rs.getInt("preferito"));
                
                }
        
        }catch(Exception e)
        {
          

        }
         
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="DELETE FROM archivio WHERE numero='"+Archivio.getSelectionModel().getSelectedItem().getNumero()+"' ";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
           
            
            ResultSet rs=pst.executeQuery();
            if(!rs.next()){
                System.out.println("errore");
            }
            else{
                System.out.println("registrato");
            }
            }catch(Exception e){
                
            }
         
         try{
            String sqlname="www";
            String sqlpassword="tw2024";
            String sqlquery="INSERT INTO contatto (nome, cognome, numero, mail, numero2, mail2, numero3 ,mail3,preferito)VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Rubrica",sqlname,sqlpassword);
            PreparedStatement pst= con.prepareStatement(sqlquery);
            pst.setString(1, temp.getNome());
            pst.setString(2, temp.getCognome());
            pst.setString(3, temp.getNumero());
            pst.setString(4, temp.getMail());
            pst.setString(5, temp.getNumero2());
            pst.setString(6, temp.getMail2());
            pst.setString(7, temp.getNumero3());
            pst.setString(8, temp.getMail3());
             pst.setInt(9, 0);
            
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
        
          archivio.remove(Archivio.getSelectionModel().getSelectedItem());
    }

    public void ritorna(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Rubrica.fxml"));
        
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     }
        
        
        
        
        
    }